package com.ssafy.devoca.quiz.model.mapper;

import com.ssafy.devoca.quiz.model.QuizDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface QuizMapper {
    public void createQuizId(int type) throws SQLException;
    public int getQuizId(int type) throws SQLException;
    public List<QuizDTO> createQuizWordList() throws SQLException;
    public void saveQuizWord(@Param("quizList") List<QuizDTO> quizList, @Param("quizId") int QuizId)
            throws SQLException;

    public List<QuizDTO> getQuizWordList(int quizId) throws SQLException;
}
