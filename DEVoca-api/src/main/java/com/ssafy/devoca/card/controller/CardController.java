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
        log.info("registerCard 호출 : 카드 등록 요청");
        try{
            cardService.registerCard(cardDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            log.error("카드 등록 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{cardId}")
    public ResponseEntity<String> updateCard(@RequestBody CardDTO cardDTO){
        log.info("updateCard 호출 : 카드 수정 요청");
        try{
            cardService.updateCard(cardDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            log.error("카드 수정 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable("cardId") int cardId){
        log.info("deleteCard 호출 : 카드 삭제 요청");
        try {
            cardService.deleteCard(cardId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            log.error("카드 삭제 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardDTO> getCardDetail(@PathVariable("cardId") int cardId){
        log.info("getCardDetail 호출 : 카드 상세정보 요청");
        try {
            //향후 session에서 loginUserId 뽑아 같이 보내기
            CardDTO cardDetail = cardService.getCardDetail(cardId);
            return ResponseEntity.status(HttpStatus.OK).body(cardDetail);
        }catch(Exception e){
            log.error("카드 상세 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/list/{scroll}")
    public ResponseEntity<List<CardDTO>> getCardList(@PathVariable("scroll") int scroll){
        log.info("getCardList 호출 : 카드 목록 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            List<CardDTO> cardList = cardService.getCardList(scroll, loginUserId);
            return ResponseEntity.status(HttpStatus.OK).body(cardList);
        }catch (Exception e){
            log.error("카드 목록 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/list/{userId}/{scroll}")
    public ResponseEntity<List<CardDTO>> getCardListByUserId(@PathVariable("userId") String userId, @PathVariable("scroll") int scroll){
        log.info("getCardListByUserId 호출 : " + userId + "의 카드 목록 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            List<CardDTO> cardList = cardService.getCardListByUserId(userId, scroll, loginUserId);
            return ResponseEntity.status(HttpStatus.OK).body(cardList);
        }catch (Exception e){
            log.error("카드 목록 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/repost")
    public ResponseEntity<String> repostCard (@RequestBody CardDTO cardDTO){
        log.info("repostCard 호출 : 카드 재게시 요청");
        try{
            cardService.repostCard(cardDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            log.error("카드 재게시 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
