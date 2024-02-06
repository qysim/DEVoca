package com.ssafy.devoca.vocalist.service;

import com.ssafy.devoca.vocalist.model.vocalistDTO;

import java.util.List;
import java.util.Map;

public interface VocalistService {

    void createVocalist(Map<String, Object> params) throws Exception;
    List<vocalistDTO> getVocalist(Integer userIdx) throws Exception;
}
