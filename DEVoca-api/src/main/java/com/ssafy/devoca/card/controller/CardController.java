package com.ssafy.devoca.card.controller;

import com.ssafy.devoca.card.model.CardDTO;
import com.ssafy.devoca.card.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    @PostMapping("")
    public ResponseEntity<String> registerCard(@RequestBody CardDTO cardDTO){
        log.info("registerCard 호출");
        try{
            cardService.registerCard(cardDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            log.error("카드 등록 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardDTO> getCardDetail(@PathVariable("cardId") int cardId){
        log.info("getCardDetail 호출");
        try {
            CardDTO cardDetail = cardService.getCardDetail(cardId);
            log.info("불러온 데이터 : ", cardDetail);
            return ResponseEntity.status(HttpStatus.OK).body(cardDetail);
        }catch(Exception e){
            log.error("카드 상세 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/list/{scroll}")
    public ResponseEntity<List<CardDTO>> getCardList(@PathVariable("scroll") int scroll){
        log.info("getCardList 호출");
        try{
            String userId = "ffasy";
            List<CardDTO> cardList = cardService.getCardList(scroll, userId);
            log.info("불러온 데이터 : ", cardList);
            return ResponseEntity.status(HttpStatus.OK).body(cardList);
        }catch (Exception e){
            log.error("카드 목록 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
