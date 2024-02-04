package com.ssafy.devoca.search.service;

import com.ssafy.devoca.card.model.CardDTO;
import com.ssafy.devoca.word.model.WordDTO;

import java.util.List;

public interface SearchService {
    public void saveSearchKeyword(String keyword, int loginUserIdx) throws Exception;

    public List<WordDTO> searchWord(String keyword, int scroll) throws Exception;

    public void updateWordSearchedCnt(int wordId) throws Exception;

    public List<CardDTO> searchCard(String keyword, int scroll, int loginUserIdx) throws Exception;

    List<WordDTO> searchRecommendWord() throws Exception;

    List<String> getRecentKeyword(int loginUserIdx) throws Exception;
}
