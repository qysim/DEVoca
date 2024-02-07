package com.ssafy.devoca.dm.controller;

import com.ssafy.devoca.dm.model.DmRoomDTO;
import com.ssafy.devoca.dm.service.DmService;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dm")
public class DmController {

    private final DmService dmService;
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<DmRoomDTO>> getDmRoomList() {

        try {
            // 유저 idx 가져오기
            String userId = "aabbc";
            int loginUserIdx = userService.loadUserIdx(userId);

            List<DmRoomDTO> dmRoomList = dmService.getDmRoomList(loginUserIdx);
            return ResponseEntity.status(HttpStatus.OK).body(dmRoomList);
        } catch (Exception e) {
            log.error("wordList 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}