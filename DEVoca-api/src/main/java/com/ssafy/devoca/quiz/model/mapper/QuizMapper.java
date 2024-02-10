package com.ssafy.devoca.quiz.model.mapper;

import com.ssafy.devoca.quiz.model.QuizAnswerDTO;
import com.ssafy.devoca.quiz.model.QuizDTO;
import com.ssafy.devoca.quiz.model.QuizListDTO;
import com.ssafy.devoca.quiz.model.QuizResultDTO;
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

    public void saveQuizResult(QuizResultDTO quizResultDTO) throws SQLException;

    public void saveQuizAnswerList(@Param("userIdx") int userIdx, @Param("list") List<QuizAnswerDTO> quizAnswerDTOList)
            throws SQLException;

    public int getQuizCnt(int loginUserIdx) throws SQLException;

    public List<QuizListDTO> getQuizResultList(int loginUserIdx) throws SQLException;

    public List<QuizResultDTO> getQuizResultDetail(@Param("loginUserIdx") int loginUserIdx, @Param("quizId") int quizId)
            throws SQLException;
}
