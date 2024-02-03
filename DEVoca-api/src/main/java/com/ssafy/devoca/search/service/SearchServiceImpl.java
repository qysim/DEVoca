package com.ssafy.devoca.search.service;

import com.ssafy.devoca.card.model.CardDTO;
import com.ssafy.devoca.search.model.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService{

    private final SearchMapper searchMapper;

    @Override
    public void saveSearchKeyword(String keyword, int loginUserIdx) throws Exception {
        searchMapper.saveSearchKeyword(keyword, loginUserIdx);
    }

    @Override
    public List<CardDTO> searchCard(String keyword, int scroll, int loginUserIdx) throws Exception {
        return searchMapper.searchCard(keyword, scroll * 10, loginUserIdx);
    }
}
