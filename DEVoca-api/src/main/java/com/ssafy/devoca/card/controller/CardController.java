package com.ssafy.devoca.card.controller;

import com.ssafy.devoca.card.model.CardDTO;
import com.ssafy.devoca.card.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return exceptionHandling(e);
        }
    }

    public ResponseEntity<String> exceptionHandling(Exception e){
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
