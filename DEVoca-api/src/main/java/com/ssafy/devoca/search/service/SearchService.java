package com.ssafy.devoca.search.service;

import com.ssafy.devoca.card.model.CardDTO;

import java.util.List;

public interface SearchService {
    public void saveSearchKeyword(String keyword, int loginUserIdx) throws Exception;

    public List<CardDTO> searchCard(String keyword, int scroll, int loginUserIdx) throws Exception;
}
