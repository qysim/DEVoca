package com.ssafy.devoca.dm.service;

import com.ssafy.devoca.dm.model.DmDTO;
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

    public void redisEnterUser(String roomUuid, String userId) {
        log.info("enter 호출 : {} {}", roomUuid, userId);
        redisTemplate.opsForList().rightPush(roomUuid, userId);
        log.info("redis user 저장 완료");
    }

    public void redisSaveMessage(String roomUuid, DmDTO dmDTO) {
        log.info("redisSaveMessage 호출 : {} {}", roomUuid, dmDTO);

        String key = roomUuid + dmDTO.getSendUserId();

        redisTemplate.opsForList().rightPush(key, dmDTO);
        log.info("redis message 저장 완료");
    }

    public List<Object> getRedisMessage(String roomUuid, String userId) {
        log.info("getRedisMessage 호출 : {} {}", roomUuid, userId);

        String key = roomUuid + userId;

        return redisTemplate.opsForList().range(key, 0, -1);
    }

    public void deletRedisMessage(String roomUuid, String userId) {
        log.info("deletRedisMessage 호출 : {} {}", roomUuid, userId);
        String key = roomUuid + userId;
        redisTemplate.delete(key);
        log.info("redisMessage 삭제 완료 : {} {}", roomUuid, userId);
    }

    public void redisUserExit(String roomUuid, String userId) {
        log.info("exit 호출 : {} {}", roomUuid, userId);
        redisTemplate.opsForList().remove(roomUuid, 0, userId);
        log.info("redis user 삭제 완료");

        Long userCnt = redisTemplate.opsForList().size(roomUuid);
        if(userCnt == 0) {
            // push 알림 보내기
            log.info("push 알림 보내장");
        }
    }
}
