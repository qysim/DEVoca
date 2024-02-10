package com.ssafy.devoca.comment.service;

import com.ssafy.devoca.comment.model.CommentDTO;
import com.ssafy.devoca.comment.model.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    @Override
    public List<CommentDTO> getCommentList(String flag, int cardBoardId) throws Exception {
        return commentMapper.getCommentList(flag, cardBoardId);
    }

    @Override
    public void registComment(Map<String, Object> map) throws Exception {
        commentMapper.registComment(map);
    }
}
