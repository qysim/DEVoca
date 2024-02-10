package com.ssafy.devoca.quiz.service;

import com.ssafy.devoca.quiz.model.QuizDTO;
import com.ssafy.devoca.quiz.model.QuizListDTO;
import com.ssafy.devoca.quiz.model.QuizResultDTO;
import com.ssafy.devoca.quiz.model.mapper.QuizMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{

    private final QuizMapper quizMapper;

    @Override
    public int createQuiz() throws Exception {
        log.info("createQuizId 호출 : 퀴즈 아이디 새로 생성");
        quizMapper.createQuizId(0);

        log.info("getQuizId 호출 : 생성한 퀴즈 아이디 가져오기");
        int quizId = quizMapper.getQuizId(0);

        log.info("createQuizWordList 호출 : 퀴즈로 만들 10개 단어 가져오기");
        List<QuizDTO> quizList = quizMapper.createQuizWordList();
        log.info(Arrays.toString(quizList.toArray()));

        log.info("saveQuizWord 호출 : 퀴즈 아이디에 단어로 다시 저장");
        quizMapper.saveQuizWord(quizList, quizId);

        return quizId;
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

    @Override
    public void saveQuizResult(QuizResultDTO quizResultDTO) throws Exception{
        quizMapper.saveQuizResult(quizResultDTO);
        quizMapper.saveQuizAnswerList(quizResultDTO.getUserIdx(), quizResultDTO.getQuizAnswerDTOList());
    }

    @Override
    public int getQuizCnt(int loginUserIdx) throws Exception {
        return quizMapper.getQuizCnt(loginUserIdx);
    }

    @Override
    public List<QuizListDTO> getQuizResultList(int loginUserIdx) throws Exception {
        return quizMapper.getQuizResultList(loginUserIdx);
    }

    @Override
    public List<QuizResultDTO> getQuizResultDetail(int loginUserIdx, int quizId) throws Exception {
        return quizMapper.getQuizResultDetail(loginUserIdx, quizId);
    }


}
