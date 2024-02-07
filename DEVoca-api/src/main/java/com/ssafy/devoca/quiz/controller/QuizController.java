package com.ssafy.devoca.quiz.controller;

import com.ssafy.devoca.notify.service.NotifyService;
import com.ssafy.devoca.quiz.model.QuizDTO;
import com.ssafy.devoca.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
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
    private final NotifyService notifyService;

    // 스케줄러 설정 : 월~금 오전 8시 35분에 퀴즈 생성 및 저장 메서드 실행
    @Scheduled(cron = "0 52 15 ? * MON-FRI", zone = "Asia/Seoul")
    @PostMapping("")
    public ResponseEntity<String> createQuiz(){
        log.info("createQuiz 호출 : 퀴즈 생성 및 저장 요청");
        try{
            int quizId = quizService.createQuiz();

            // 퀴즈 생성 푸시알림 전송
            List<Integer> allUserIdx = notifyService.getAllUserIdx();
            for(Integer userIdx : allUserIdx){
                notifyService.send(userIdx, 5, quizId);
            }

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
