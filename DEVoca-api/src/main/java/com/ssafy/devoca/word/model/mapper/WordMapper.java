package com.ssafy.devoca.word.model.mapper;

import com.ssafy.devoca.word.model.WordDTO;

import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface WordMapper {
    public List<WordDTO> getWordList() throws SQLException;
}
