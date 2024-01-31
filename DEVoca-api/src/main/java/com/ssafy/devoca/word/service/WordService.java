package com.ssafy.devoca.word.service;

import com.ssafy.devoca.word.model.WordDTO;

import java.util.List;

public interface WordService {
    public List<WordDTO> getWordList(String alphabet) throws Exception;
}
