package com.ssafy.devoca.word.service;

import com.ssafy.devoca.word.model.WordDTO;
import com.ssafy.devoca.word.model.mapper.WordMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService{

    private final WordMapper wordMapper;

    /**
     * 단어 사전 진입 시 단어 목록 조회
     *
     * @return 단어 목록
     * @throws Exception
     */
    @Override
    public List<WordDTO> getWordList(String alphabet) throws Exception {
        return wordMapper.getWordList(alphabet);
    }
}
