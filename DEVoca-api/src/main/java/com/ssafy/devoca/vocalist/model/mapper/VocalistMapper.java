package com.ssafy.devoca.vocalist.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface VocalistMapper {

    void createVocaList(Map<String, Object> params) throws Exception;
}
