package com.ssafy.devoca.word.controller;

import com.ssafy.devoca.word.model.NewsDTO;
import com.ssafy.devoca.word.model.WordDTO;
import com.ssafy.devoca.word.model.WordDetailDTO;
import com.ssafy.devoca.word.service.WordService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


/**
 * 단어 사전 Controller
 *
 * @author kimjuyi
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/dictionary")
public class WordController {

    private final WordService wordService;

    /**
     * 단어 사전 진입 시 단어 목록 조회
     *
     * @return HttpStatus.OK, 단어 목록
     */
    @GetMapping("/{alphabet}")
    public ResponseEntity<List<WordDTO>> getWordList(@PathVariable("alphabet") String alphabet) {

        log.info("getWordList 호출 : " + alphabet);

        /**
         * 올바른 PATH인지 확인
         *
         * alphabet의 길이가 1이 아니거나,
         * 1글자일 때 a~z, A~Z 사이가 아닐 경우
         *
         * 400 BAD_REQUEST 반환
         */
        if(alphabet.length() != 1 ||
                !((alphabet.charAt(0) >= 'a' && alphabet.charAt(0) <= 'z') || (alphabet.charAt(0) >= 'A') && (alphabet.charAt(0) <= 'Z'))) {
            log.error("wordList 조회 실패 : Bad Request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            List<WordDTO> wordList = wordService.getWordList(alphabet);
            return ResponseEntity.status(HttpStatus.OK).body(wordList);
        } catch (Exception e) {
            log.error("wordList 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 단어 상세 (단어, 뉴스) 조회
     *
     * @param wordId 단어 아이디
     * @return 단어 데이터, 뉴스 데이터 리스트
     */
    @GetMapping("/detail/{wordId}")
    public ResponseEntity<WordDetailDTO> getWordDetail(@PathVariable("wordId") int wordId) {
        log.info("getWordDetail 호출 : {}", wordId);

        try {
            WordDetailDTO wordDetailDTO = wordService.getWordDetail(wordId);
            return ResponseEntity.status(HttpStatus.OK).body(wordDetailDTO);
        } catch (Exception e) {
            log.error("getWordDetail 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
