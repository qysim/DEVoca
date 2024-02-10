package com.ssafy.devoca.quiz.service;

import com.ssafy.devoca.quiz.model.QuizDTO;
import com.ssafy.devoca.quiz.model.QuizListDTO;
import com.ssafy.devoca.quiz.model.QuizResultDTO;

import java.util.List;

public interface QuizService {
    public int createQuiz() throws Exception;

    public List<QuizDTO> getQuiz() throws Exception;

    public void saveQuizResult(QuizResultDTO quizResultDTO) throws Exception;

    public int getQuizCnt(int loginUserIdx) throws Exception;

    public List<QuizListDTO> getQuizResultList(int loginUserIdx) throws Exception;

    public List<QuizResultDTO> getQuizResultDetail(int loginUserIdx, int quizId) throws Exception;
}
