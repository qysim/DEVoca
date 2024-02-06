//package com.ssafy.devoca.vocalist.service;
//
//import com.ssafy.devoca.vocalist.model.VocalistDTO;
//import com.ssafy.devoca.vocalist.model.mapper.VocalistMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class VocalistServiceImpl implements VocalistService{
//
//    private final VocalistMapper vocalistMapper;
//
//    @Override
//    @Transactional
//    public void createVocalist(VocalistDTO vocalistDTO) throws Exception {
//        vocalistMapper.createVocaList(vocalistDTO);
//        storeVocalist(vocalistDTO);
//    }
//
//    @Override
//    public List<VocalistDTO> getVocalist(Integer userIdx) throws Exception {
//        return vocalistMapper.getVocalist(userIdx);
//    }
//
//    @Override
//    public void storeVocalist(VocalistDTO vocalistDTO) throws Exception {
//        vocalistMapper.storeVocalist(vocalistDTO);
//    }
//
//
//
//}
