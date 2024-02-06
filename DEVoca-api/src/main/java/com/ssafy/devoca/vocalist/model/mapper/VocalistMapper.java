package com.ssafy.devoca.vocalist.model.mapper;

import com.ssafy.devoca.vocalist.model.vocalistDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface VocalistMapper {

    void createVocaList(Map<String, Object> params) throws SQLException;
    List<vocalistDTO> getVocalist(Integer userIdx) throws SQLException;
}
