package com.ssafy.devoca.board.model.mapper;


import com.ssafy.devoca.board.model.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface BoardMapper {

    public BoardDTO getBlogInfo() throws SQLException;
}
