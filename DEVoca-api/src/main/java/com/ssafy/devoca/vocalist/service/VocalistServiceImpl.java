package com.ssafy.devoca.vocalist.service;

import com.ssafy.devoca.vocalist.model.mapper.VocalistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class VocalistServiceImpl implements VocalistService{

    private final VocalistMapper vocalistMapper;

    @Override
    public void createVocalist(Map<String, Object> params) throws Exception {
        vocalistMapper.createVocaList(params);
    }
}
