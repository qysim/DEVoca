package com.ssafy.devoca.search.controller;

import com.ssafy.devoca.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @PostMapping("")
    public ResponseEntity<String> saveSearchKeyword(@RequestParam("keyword") String keyword){
        log.info("saveSearchKeyword 호출 : 검색 키워드 저장 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            int loginUserIdx = 8;
            searchService.saveSearchKeyword(keyword, loginUserIdx);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            log.error("검색 키워드 저장 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
