package com.ssafy.devoca.quiz.service;

import com.ssafy.devoca.quiz.model.QuizDTO;
import com.ssafy.devoca.quiz.model.mapper.QuizMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{

    private final QuizMapper quizMapper;

    @Override
    public void createQuiz() throws Exception {
        log.info("createQuizId 호출 : 퀴즈 아이디 새로 생성");
        quizMapper.createQuizId(0);

        log.info("getQuizId 호출 : 생성한 퀴즈 아이디 가져오기");
        int quizId = quizMapper.getQuizId(0);

        log.info("createQuizWordList 호출 : 퀴즈로 만들 10개 단어 가져오기");
        List<QuizDTO> quizList = quizMapper.createQuizWordList();
        log.info(Arrays.toString(quizList.toArray()));

        log.info("saveQuizWord 호출 : 퀴즈 아이디에 단어로 다시 저장");
        quizMapper.saveQuizWord(quizList, quizId);
    }

    @Override
    public List<QuizDTO> getQuiz() throws Exception {
        log.info("getQuizId 호출 : 생성한 퀴즈 아이디 가져오기");
        int quizId = quizMapper.getQuizId(0);

        log.info("getQuizWordList 호출 : 퀴즈 단어 가져오기");
        List<QuizDTO> quizList = quizMapper.getQuizWordList(quizId);
        log.info(Arrays.toString(quizList.toArray()));

        return quizList;
    }


}
