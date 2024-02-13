package com.ssafy.devoca.dm.service;

import com.ssafy.devoca.dm.model.DmDTO;
import com.ssafy.devoca.notify.service.NotifyService;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Redis에 데이터 저장 Service
 *
 * @author kimjuyi
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final UserService userService;
    private final DmService dmService;
    private final NotifyService notifyService;

    public void redisEnterUser(String roomUuid, String userId) {
        log.info("enter 호출 : {} {}", roomUuid, userId);

        // 이미 저장되어 있는지 확인
        Boolean alreadyExistsUser = redisTemplate.opsForList().range(roomUuid, 0, -1).contains(userId);
        log.info("alreadyExistsUser : {}" , alreadyExistsUser);

        if(!alreadyExistsUser) {
            redisTemplate.opsForList().rightPush(roomUuid, userId);
            log.info("redis user 저장 완료");
        }
    }

    public void redisUserExit(String roomUuid, String userId) {
        log.info("exit 호출 : {} {}", roomUuid, userId);
        redisTemplate.opsForList().remove(roomUuid, 0, userId);
        log.info("redis user 삭제 완료");

        Long userCnt = redisTemplate.opsForList().size(roomUuid);
        if(userCnt == 0) {
            // push 알림 보내기
            try {
                int userIdx = userService.loadUserIdxById(userId);
                int pushUserIdx = dmService.getChatUserIdx(roomUuid, userIdx);
                int roomIdx = dmService.getRoomIdxByRoomUuid(roomUuid);
                notifyService.send(pushUserIdx, 4, roomIdx);
                log.info("push 알림 보내기 성공 : {}", pushUserIdx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
