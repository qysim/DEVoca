package com.ssafy.devoca.comment.service;

import com.ssafy.devoca.comment.model.CommentDTO;

import java.util.List;

public interface CommentService {
    public List<CommentDTO> getCommentList(String flag, int cardBoardId) throws Exception;
}
