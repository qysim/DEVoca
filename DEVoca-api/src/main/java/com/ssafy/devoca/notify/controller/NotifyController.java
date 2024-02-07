package com.ssafy.devoca.notify.controller;

import com.ssafy.devoca.notify.service.NotifyService;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/notify")
public class NotifyController {
    private  final NotifyService notifyService;
    private final UserService userService;

    @GetMapping(value = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter connect(@RequestParam("Last-Event-ID") String lastEventId){
        log.info("connect 호출 : SseEmitter connect 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            return notifyService.connect(loginUserIdx, lastEventId);
        }catch (Exception e){
            log.error("connect 실패", e);
            return null;
        }
    }
    
    // 지금까지의 모든 알림 isRead true로 바꾸는 메서드

}
