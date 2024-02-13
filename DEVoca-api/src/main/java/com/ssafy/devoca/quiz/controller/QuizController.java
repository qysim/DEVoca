package com.ssafy.devoca.quiz.controller;

import com.ssafy.devoca.notify.service.NotifyService;
import com.ssafy.devoca.quiz.model.*;
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
    @Scheduled(cron = "0 35 8 ? * MON-FRI", zone = "Asia/Seoul")
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

    @GetMapping("/{quizId}")
    public ResponseEntity<List<QuizDTO>> getQuiz(@PathVariable("quizId") int quizId){
        log.info("getQuiz 호출 : 퀴즈 조회 요청");
        try{
            List<QuizDTO> quizList = quizService.getQuiz(quizId);
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
            String userId = quizResultDTO.getUserId();
            int userIdx = userService.loadUserIdx(userId);
            quizResultDTO.setUserIdx(userIdx);
            quizService.saveQuizResult(quizResultDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            log.error("퀴즈 결과 저장 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/cnt")
    public ResponseEntity<Integer> getQuizCnt(){
        log.info("getQuizCnt 호출 : 참여한 퀴즈 수 조회 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            int cnt = quizService.getQuizCnt(loginUserIdx);
            return ResponseEntity.status(HttpStatus.OK).body(cnt);
        }catch (Exception e){
            log.error("퀴즈 결과 저장 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/result")
    public ResponseEntity<List<QuizListDTO>> getQuizResultList(){
        log.info("getQuizResultList 호출 : 참여한 퀴즈 목록 조회 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            List<QuizListDTO> quizList = quizService.getQuizResultList(loginUserIdx);
            return ResponseEntity.status(HttpStatus.OK).body(quizList);
        }catch (Exception e){
            log.error("퀴즈 목록 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/result/{quizId}")
    public ResponseEntity<List<QuizResultDTO>> getQuizResultDetail(@PathVariable("quizId") int quizId){
        log.info("getQuizResultList 호출 : 참여한 퀴즈 상세 조회 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            List<QuizResultDTO> quizDetailList = quizService.getQuizResultDetail(loginUserIdx, quizId);
            return ResponseEntity.status(HttpStatus.OK).body(quizDetailList);
        }catch (Exception e){
            log.error("퀴즈 상세 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/battle/vocalist")
    public ResponseEntity<List<QuizVocaDTO>> getBattleVocaList(@RequestParam("oppoUserId") String oppoUserId){
        log.info("getBattleVocaList 호출 : 사용자와 상대방의 단어장 목록 조회 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            int loginUserIdx = userService.loadUserIdx(loginUserId);
            int oppoUserIdx = userService.loadUserIdx(oppoUserId);
            List<QuizVocaDTO> battleVocaList = quizService.getBattleVocaList(loginUserIdx, oppoUserIdx);
            return ResponseEntity.status(HttpStatus.OK).body(battleVocaList);
        }catch (Exception e){
            log.error("사용자와 상대방의 단어장 목록 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/battle")
    public ResponseEntity<String> createBattle(@RequestBody BattleRequestDTO battleRequestDTO){
        log.info("createQuiz 호출 : 퀴즈 생성 및 저장 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
            String loginUserId = "aabbccc";
            battleRequestDTO.setFromUserId(loginUserId);

            int fromUserIdx = userService.loadUserIdx(battleRequestDTO.getFromUserId());
            int toUserIdx = userService.loadUserIdx(battleRequestDTO.getToUserId());
            battleRequestDTO.setFromUserIdx(fromUserIdx);
            battleRequestDTO.setToUserIdx(toUserIdx);
            int quizId = quizService.createBattle(battleRequestDTO);

            //기능 미구현 :: quizId 포함 dm 전송 -> dm db boolean 값 quizId int로 변경 필요

            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            log.error("퀴즈 생성 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/battle/save")
    public ResponseEntity<String> saveBattleResult(@RequestBody QuizResultDTO quizResultDTO){
        log.info("saveBattleResult 호출 : 대결 퀴즈 결과 저장 요청");
        try{
            String userId = quizResultDTO.getUserId();
            int userIdx = userService.loadUserIdx(userId);
            quizResultDTO.setUserIdx(userIdx);
            quizService.saveBattleResult(quizResultDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            log.error("퀴즈 결과 저장 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/battle/result/{quizId}")
    public ResponseEntity<List<BattleResultDTO>> getBattleResultDetail(@PathVariable("quizId") int quizId){
        log.info("getQuizResultList 호출 : 참여한 대결 퀴즈 상세 조회 요청");
        try{
            //향후 session에서 loginUserId 뽑아 같이 보내기
//            String loginUserId = "aabbccc";
//            int loginUserIdx = userService.loadUserIdx(loginUserId);
            int loginUserIdx = 8;
            List<BattleResultDTO> quizDetailList = quizService.getBattleResultDetail(loginUserIdx, quizId);
            return ResponseEntity.status(HttpStatus.OK).body(quizDetailList);
        }catch (Exception e){
            log.error("퀴즈 상세 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
