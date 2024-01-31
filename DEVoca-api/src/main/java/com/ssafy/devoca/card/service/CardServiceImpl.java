package com.ssafy.devoca.card.service;

import com.ssafy.devoca.card.model.CardDTO;
import com.ssafy.devoca.card.model.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

    private final CardMapper cardMapper;

    @Override
    public void registerCard(CardDTO cardDTO) throws Exception {
        cardMapper.registerCard(cardDTO);
    }

    @Override
    public CardDTO getCardDetail(int cardId) throws Exception{
        return cardMapper.getCardDetail(cardId);
    }

    @Override
    public List<CardDTO> getCardList(int scroll, String userId) throws Exception {
        return cardMapper.getCardList(scroll * 10, userId);
    }
}
