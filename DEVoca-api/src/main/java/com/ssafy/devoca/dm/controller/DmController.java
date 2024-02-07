package com.ssafy.devoca.dm.controller;

import com.ssafy.devoca.dm.model.DmDTO;
import com.ssafy.devoca.dm.model.DmRoomDTO;
import com.ssafy.devoca.dm.service.DmService;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DM 관련 Controller
 *
 * @author kimjuyi
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dm")
public class DmController {

    private final DmService dmService;
    private final UserService userService;

    /**
     * DM 목록 페이지 진입 시 로그인 한 유저의 DM 채팅방 목록 조회
     *
     * @return Dm 채팅방 정보 리스트
     *         (상대 유저 이미지, 상대 유저 닉네임, 마지막 메시지, 메시지 작성 시간, 안읽은 메시지 수)
     */
    @GetMapping("")
    public ResponseEntity<List<DmRoomDTO>> getDmRoomList() {
        log.info("getDmRoomList 호출");
        try {
            // 유저 idx 가져오기
            String userId = "aabbc";
            int loginUserIdx = userService.loadUserIdx(userId);

            List<DmRoomDTO> dmRoomList = dmService.getDmRoomList(loginUserIdx);
            return ResponseEntity.status(HttpStatus.OK).body(dmRoomList);
        } catch (Exception e) {
            log.error("getDmRoomList 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 채팅방 진입 시 채팅 내역 조회
     * 무한스크롤(한 번에 10개의 메시지 데이터)
     *
     * @param roomUuid 채팅방 랜덤 아이디
     * @param scroll 스크롤 횟수
     * @return DmDTO의 리스트
     */
    @GetMapping("/{roomUuid}/{scroll}")
    public ResponseEntity<List<DmDTO>> getDmList(@PathVariable("roomUuid") String roomUuid, @PathVariable("scroll") int scroll) {

        log.info("getDmList 호출 : {} {}", roomUuid, scroll);
        try {
            // 유저 idx 가져오기
            String userId = "aabbc";
            int loginUserIdx = userService.loadUserIdx(userId);

            // 해당 유저가 채팅방 참여자가 아닐 경우 BAD_REQUEST 반환
            if(!dmService.getParticipantsYN(roomUuid, loginUserIdx)) {
                log.error("getDmList 조회 실패 : 접근 권한 없음.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            List<DmDTO> DmList = dmService.getDmList(roomUuid, scroll);
            return ResponseEntity.status(HttpStatus.OK).body(DmList);

        } catch (Exception e) {
            log.error("getDmList 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}