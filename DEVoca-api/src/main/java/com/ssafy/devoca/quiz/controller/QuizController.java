package com.ssafy.devoca.quiz.controller;

import com.ssafy.devoca.notify.service.NotifyService;
import com.ssafy.devoca.quiz.model.QuizDTO;
import com.ssafy.devoca.quiz.model.QuizResultDTO;
import com.ssafy.devoca.quiz.service.QuizService;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private final NotifyService notifyService;
    private final UserService userService;

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

    @PostMapping("/save")
    public ResponseEntity<String> saveQuizResult(@RequestBody QuizResultDTO quizResultDTO){
        log.info("saveQuizResult 호출 : 퀴즈 결과 저장 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            quizResultDTO.setUserIdx(loginUserIdx);
            quizService.saveQuizResult(quizResultDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            log.error("퀴즈 결과 저장 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
