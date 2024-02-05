//package com.ssafy.devoca.dm.controller;
//
//import com.ssafy.devoca.dm.service.RedisPublisher;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.stereotype.Controller;
//
///**
// * DM 관련 Controller
// *
// * @author kimjuyi
// */
//@Slf4j
//@Controller
//@RequiredArgsConstructor
//public class DmController {
//    private final RedisPublisher redisPublisher;
//    private final ChannelTopic channelTopic;
//
//    @MessageMapping("/chat")
//    public void handleChatMessage(String message) {
//        log.info("hadleChatMessage 호출 : {}", message);
//        redisPublisher.publish(channelTopic, message);
//    }
//}
