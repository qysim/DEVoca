package com.ssafy.devoca.search.service;

public interface SearchService {
    void saveSearchKeyword(String keyword, int loginUserIdx) throws Exception;
}
