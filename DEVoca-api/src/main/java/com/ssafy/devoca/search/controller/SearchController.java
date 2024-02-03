package com.ssafy.devoca.search.controller;

import com.ssafy.devoca.card.model.CardDTO;
import com.ssafy.devoca.search.service.SearchService;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;
    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<String> saveSearchKeyword(@RequestParam("keyword") String keyword){
        log.info("saveSearchKeyword 호출 : 검색 키워드 저장 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            searchService.saveSearchKeyword(keyword, loginUserIdx);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            log.error("검색 키워드 저장 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/card/{keyword}/{scroll}")
    public ResponseEntity<List<CardDTO>> searchCard(@PathVariable("keyword") String keyword, @PathVariable("scroll") int scroll){
        log.info("saveWord 호출 : 카드 검색 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            List<CardDTO> cardList = searchService.searchCard(keyword, scroll, loginUserIdx);
            return ResponseEntity.status(HttpStatus.OK).body(cardList);
        }catch (Exception e){
            log.error("카드 검색 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
