package com.ssafy.devoca.quiz.service;

import com.ssafy.devoca.quiz.model.QuizDTO;
import com.ssafy.devoca.quiz.model.QuizResultDTO;

import java.util.List;

public interface QuizService {
    public int createQuiz() throws Exception;

    public List<QuizDTO> getQuiz() throws Exception;

    public void saveQuizResult(QuizResultDTO quizResultDTO) throws Exception;
}
