package com.ssafy.devoca.quiz.controller;

import com.ssafy.devoca.quiz.model.QuizDTO;
import com.ssafy.devoca.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("")
    public ResponseEntity<String> createQuiz(){
        log.info("createQuiz 호출 : 퀴즈 생성 및 저장 요청");
        try{
            quizService.createQuiz();
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            log.error("퀴즈 생성 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<QuizDTO>> getQuiz(){
        log.info("getQuiz 호출 : 퀴즈 조회 요청");
        try{
            List<QuizDTO> quizList = quizService.getQuiz();
            return ResponseEntity.status(HttpStatus.OK).body(quizList);
        }catch (Exception e){
            log.error("퀴즈 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
