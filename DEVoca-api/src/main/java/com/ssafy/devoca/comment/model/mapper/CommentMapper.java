package com.ssafy.devoca.comment.model.mapper;

import com.ssafy.devoca.comment.model.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {
    public List<CommentDTO> getCommentList(@Param("flag") String flag, @Param("cardBoardId") int cardBoardId) throws SQLException;
    public void registComment(Map<String, Object> map) throws SQLException;
}
