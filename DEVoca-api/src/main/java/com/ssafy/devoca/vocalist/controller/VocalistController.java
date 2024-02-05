package com.ssafy.devoca.vocalist.controller;

import com.ssafy.devoca.user.service.UserService;
import com.ssafy.devoca.vocalist.service.VocalistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vocalist")
@Slf4j
public class VocalistController {

    private final UserService userService;
    private final VocalistService vocalistService;

    @PostMapping("")
    public ResponseEntity<String> createVocalist(@RequestHeader("userId") String userId
                                                 , @RequestBody String vocalistName){
        log.info("단어장 생성 api 호출");
        try{
            int userIdx = userService.loadUserIdx(userId);
            Map<String, Object> params = new HashMap<>();
            params.put("userIdx", userIdx);
            params.put("vocalistName", vocalistName);
            log.info("params : {}", params);
            vocalistService.createVocalist(params);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.info("단어장 생성 api 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
