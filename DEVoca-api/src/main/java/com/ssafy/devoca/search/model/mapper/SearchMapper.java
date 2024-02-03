package com.ssafy.devoca.search.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

@Mapper
public interface SearchMapper {

    void saveSearchKeyword(@Param("keyword") String keyword, @Param("loginUserIdx") int loginUserIdx) throws SQLException;
}