package com.ssafy.devoca.card.service;

import com.ssafy.devoca.card.model.CardDTO;
import com.ssafy.devoca.card.model.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardMapper cardMapper;

    @Override
    public void registerCard(CardDTO cardDTO) throws Exception {
        cardMapper.registerCard(cardDTO);
    }
}
