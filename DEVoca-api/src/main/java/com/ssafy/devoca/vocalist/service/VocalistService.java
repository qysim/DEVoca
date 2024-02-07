package com.ssafy.devoca.vocalist.service;

import com.ssafy.devoca.vocalist.model.VldetailDTO;
import com.ssafy.devoca.vocalist.model.VocalistDTO;

import java.util.List;
import java.util.Map;

public interface VocalistService {

    void createVocalist(VocalistDTO vocalistDTO) throws Exception;
    List<VocalistDTO> getVocalist(Integer userIdx) throws Exception;
    void storeVocalist(VocalistDTO vocalistDTO) throws Exception;
    void deleteVocalist(Map<String, Integer> params) throws Exception;
    List<VldetailDTO> getVocalistDetail(Integer vocaListId, Integer userIdx) throws Exception;
}
