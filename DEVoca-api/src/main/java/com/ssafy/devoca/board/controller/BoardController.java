package com.ssafy.devoca.board.controller;

import com.ssafy.devoca.board.model.BoardDTO;
import com.ssafy.devoca.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public BoardDTO getBlogInfo() throws Exception{
        return boardService.getBlogInfo();
    }
}
