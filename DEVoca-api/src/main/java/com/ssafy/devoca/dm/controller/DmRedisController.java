package com.ssafy.devoca.dm.controller;

import com.ssafy.devoca.dm.model.DmDTO;
import com.ssafy.devoca.dm.model.LastDateDTO;
import com.ssafy.devoca.dm.service.DmService;
import com.ssafy.devoca.dm.service.RedisPublisher;
import com.ssafy.devoca.dm.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * DM Redis 관련 Controller
 *
 * @author kimjuyi
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class DmRedisController {
    private final RedisPublisher redisPublisher;
    private final ChannelTopic channelTopic;

    private final RedisService redisService;
    private final DmService dmService;

    @MessageMapping("/chat/{roomUuid}/enter")
    public void userEnter(@DestinationVariable("roomUuid") String roomUuid, String userId) {
        log.info("userEnter : {} {}", roomUuid, userId);
        redisService.redisEnterUser(roomUuid, userId);
    }

    @MessageMapping("/chat/{roomUuid}")
    public void handleChatMessage(@DestinationVariable("roomUuid") String roomUuid, DmDTO dmDTO) {
        log.info("hadleChatMessage 호출 : {} {}", roomUuid, dmDTO);

        try {
            int roomIdx = dmService.getRoomIdxByRoomUuid(roomUuid);
            dmDTO.setRoomIdx(roomIdx);
            redisPublisher.publish(channelTopic, dmDTO);
            redisService.redisSaveMessage(roomUuid, dmDTO);
        } catch (Exception e) {
            log.error("roomUuid로 roomIdx 가져오기 에러 : {}", e);
            throw new RuntimeException(e);
        }
    }

    @MessageMapping("/chat/{roomUuid}/exit")
    public void userExit(@DestinationVariable("roomUuid") String roomUuid, LastDateDTO lastDateDTO) {
        log.info("userExit : {} {}", roomUuid, lastDateDTO);

        List<Object> redisMessages = redisService.getRedisMessage(roomUuid, lastDateDTO.getUserId());
        List<DmDTO> dms = new ArrayList<>();

        for(Object messages : redisMessages){
            if(messages instanceof DmDTO) {
                dms.add((DmDTO) messages);
            }
        }

        log.info("dms : {}", dms.toString());

        try {
            if(dms != null) {
                dmService.saveMessages(dms);
                log.info("DB에 메시지 저장 완료 {}", dms);
            }
        } catch (Exception e) {
            log.error("DB 메시지 저장 실패 : {}", e);
            throw new RuntimeException(e);
        }
        
        // redis 저장소 삭제
        redisService.deleteRedisMessage(roomUuid, lastDateDTO.getUserId());
        redisService.redisUserExit(roomUuid, lastDateDTO.getUserId());

        // 마지막 조회 시간 업데이트
        try {
            int roomIdx = dmService.getRoomIdxByRoomUuid(roomUuid);
            lastDateDTO.setRoomIdx(roomIdx);
            dmService.updateLastDate(lastDateDTO);
        } catch (Exception e) {
            log.error("roomUuid로 roomIdx 가져오기 에러 : {}", e);
            throw new RuntimeException(e);
        }
    }
}
