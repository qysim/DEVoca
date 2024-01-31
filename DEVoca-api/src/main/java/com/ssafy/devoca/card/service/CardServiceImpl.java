package com.ssafy.devoca.card.service;

import com.ssafy.devoca.card.model.CardDTO;
import com.ssafy.devoca.card.model.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

    private final CardMapper cardMapper;

    @Override
    public void registerCard(CardDTO cardDTO) throws Exception {
        // String[] cardRelatedKeywordArray를 String cardRelatedKeyword로
        String[] tempStringArray = cardDTO.getCardRelatedKeywordList();
        if(tempStringArray.length > 0) {
            String tempString = Arrays.toString(tempStringArray);
            cardDTO.setCardRelatedKeyword(tempString);
        }
        cardMapper.registerCard(cardDTO);
    }

    @Override
    public void updateCard(CardDTO cardDTO) throws Exception {
        // String[] cardRelatedKeywordArray를 String cardRelatedKeyword로
        String[] tempStringArray = cardDTO.getCardRelatedKeywordList();
        if(tempStringArray.length > 0) {
            String tempString = Arrays.toString(tempStringArray);
            cardDTO.setCardRelatedKeyword(tempString);
        }
        cardMapper.updateCard(cardDTO);
    }

    @Override
    public void deleteCard(int cardId) throws Exception {
        cardMapper.deleteCard(cardId);
    }

    @Override
    public CardDTO getCardDetail(int cardId) throws Exception{
        CardDTO cardDTO = cardMapper.getCardDetail(cardId);

        // String cardRelatedKeyword를 String[] cardRelatedKeywordArray로
        String tempString = cardDTO.getCardRelatedKeyword();
        if(tempString != null) {
            tempString = tempString.substring(1);
            String[] tempStringArray = tempString.split(",");

            String temp = tempStringArray[tempStringArray.length - 1];
            temp = temp.substring(0, temp.length() - 1);
            tempStringArray[tempStringArray.length - 1] = temp;

            cardDTO.setCardRelatedKeywordList(tempStringArray);
        }
        return cardDTO;
    }

    @Override
    public List<CardDTO> getCardList(int scroll, String userId) throws Exception {
        return cardMapper.getCardList(scroll * 10, userId);
    }
}
