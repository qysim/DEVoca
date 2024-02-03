package com.ssafy.devoca.search.service;

import com.ssafy.devoca.search.model.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService{

    private final SearchMapper searchMapper;

    @Override
    public void saveSearchKeyword(String keyword, int loginUserIdx) throws Exception {
        searchMapper.saveSearchKeyword(keyword, loginUserIdx);
    }
}
