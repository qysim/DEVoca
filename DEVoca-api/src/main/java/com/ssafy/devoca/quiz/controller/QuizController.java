package com.ssafy.devoca.quiz.controller;

import com.ssafy.devoca.dm.model.DmDTO;
import com.ssafy.devoca.dm.service.DmService;
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

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private final NotifyService notifyService;
    private final UserService userService;
    private final DmService dmService;

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
            int userIdx = userService.loadUserIdxById(userId);
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

            int fromUserIdx = userService.loadUserIdxById(battleRequestDTO.getFromUserId());
            int toUserIdx = userService.loadUserIdxById(battleRequestDTO.getToUserId());
            battleRequestDTO.setFromUserIdx(fromUserIdx);
            battleRequestDTO.setToUserIdx(toUserIdx);
            int quizId = quizService.createBattle(battleRequestDTO);

            // dm 저장을 위한 정보 가져오기
            String roomUuid = dmService.getRoomUuid(fromUserIdx, toUserIdx);

            // 두 사용자가 참여한 채팅방이 없을 경우 새로운 채팅방 생성
            if(roomUuid == null) {
                UUID uuid = UUID.randomUUID();
                roomUuid = uuid.toString().substring(0, 8);

                dmService.createRoom(roomUuid);
                log.info("방 생성 완료");

                dmService.insertParticipants(roomUuid, fromUserIdx, toUserIdx);
                log.info("참여자 저장 완료");
            }

            int roomIdx = dmService.getRoomIdxByRoomUuid(roomUuid);

            String userNickName = userService.getUserNickName(fromUserIdx);

            // dm 내용 설정
            DmDTO dmDTO = new DmDTO();
            dmDTO.setRoomIdx(roomIdx);
            dmDTO.setSendUserId(battleRequestDTO.getFromUserId());
            dmDTO.setDmContent(userNickName + "님이 도전장을 보내셨습니다!");
            dmDTO.setDmSendDate(new Timestamp(System.currentTimeMillis()));
            dmDTO.setDmBattleQuizId(quizId);

            // dm db 저장
            dmService.saveMessage(dmDTO);

            try {
                log.info("updateLastDateSendDate");
                dmService.updateLastDateSendDate(dmDTO);
            } catch (Exception e) {
                log.error("updateLastDateSendDate 마지막 조회 시간 = 메시지 전송 시간으로 저장 에러 : {}", e);
                throw new RuntimeException(e);
            }

            // 푸시 알림 보내기
            notifyService.send(toUserIdx, 4, roomIdx);

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
            int userIdx = userService.loadUserIdxById(userId);
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
