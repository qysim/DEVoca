package com.ssafy.devoca.board.service;

import com.ssafy.devoca.board.model.BoardDTO;
import com.ssafy.devoca.board.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;

    @Override
    public BoardDTO getBlogInfo() throws Exception {
        return boardMapper.getBlogInfo();
    }

}
