package com.ssafy.devoca.notify.controller;

import com.ssafy.devoca.notify.model.NotifyDTO;
import com.ssafy.devoca.notify.service.NotifyService;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

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

    @GetMapping("/{scroll}")
    public ResponseEntity<List<NotifyDTO>> getNotification(@PathVariable("scroll") int scroll){
        log.info("getNotification 호출 : 알림창 조회");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            List<NotifyDTO> notifyDTOList = notifyService.getNotification(scroll, loginUserIdx);
            return ResponseEntity.status(HttpStatus.OK).body(notifyDTOList);
        }catch (Exception e){
            log.error("알림창 조회 실패", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
