package com.ssafy.devoca.card.service;

import com.ssafy.devoca.card.model.CardDTO;

public interface CardService {
    void registerCard(CardDTO cardDTO) throws Exception;
}
