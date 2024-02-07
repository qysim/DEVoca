package com.ssafy.devoca.vocalist.controller;

import com.ssafy.devoca.user.service.UserService;
import com.ssafy.devoca.vocalist.model.VocalistDTO;
import com.ssafy.devoca.vocalist.service.VocalistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vocalist")
@Slf4j
public class VocalistController {

    private final UserService userService;
    private final VocalistService vocalistService;

    /*
     * 단어장 생성 api
     * @author Ryu jiyun
     * */
    @PostMapping("")
    public ResponseEntity<String> createVocalist(@RequestHeader("userId") String userId
                                                 , @RequestBody VocalistDTO vocalistDTO){
        log.info("단어장 생성 api 호출");
        try{
            int userIdx = userService.loadUserIdx(userId);
            vocalistDTO.setUserIdx(userIdx);
            vocalistDTO.setVlWordCard(1);
            vocalistService.createVocalist(vocalistDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.info("단어장 생성 api 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*
    * 단어장 저장 api
    * @author Ryu jiyun
    * */
    @PostMapping("/store")
    public ResponseEntity<String> storeVocalist(@RequestHeader("userId") String userId
                                                , @RequestBody VocalistDTO vocalistDTO){
        log.info("단어장 저장 api 호출");
        try{
            int userIdx = userService.loadUserIdx(userId);
            vocalistDTO.setUserIdx(userIdx);
            vocalistDTO.setVlWordCard(1);
            vocalistService.storeVocalist(vocalistDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            log.info("단어장 저장 api 호출 실패: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<VocalistDTO>> getVocalist(@RequestHeader("userId") String userId){
        log.info("단어장 목록 api 호출");
        try{
            int userIdx = userService.loadUserIdx(userId);
            List<VocalistDTO> vocaList = vocalistService.getVocalist(userIdx);
            log.info("vocaList : {}", vocaList);
            return ResponseEntity.status(HttpStatus.OK).body(vocaList);
        } catch (Exception e){
            log.info("단어장 목록 api 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
