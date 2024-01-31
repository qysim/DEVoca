package com.ssafy.devoca.card.service;

import com.ssafy.devoca.card.model.CardDTO;

import java.util.List;

public interface CardService {
    void registerCard(CardDTO cardDTO) throws Exception;

    CardDTO getCardDetail(int cardId) throws Exception;

    List<CardDTO> getCardList(int scroll, String userId) throws Exception;
}
