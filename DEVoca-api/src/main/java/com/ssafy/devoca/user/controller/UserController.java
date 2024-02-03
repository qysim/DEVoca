package com.ssafy.devoca.user.controller;

import com.ssafy.devoca.user.model.UserDTO;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<String> joinUser(@RequestBody UserDTO userDTO) {
        log.info("user 회원가입 호출");
        try{
            userService.joinUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("회원가입 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // token 구현 전이므로 http 요청 헤더에 token 대신 userIdx 가 담겨 있다고 가정. token 유효성 검사도 추후 구현 예정.
    @GetMapping("")
    public ResponseEntity<UserDTO> getUserInfo(@RequestHeader("userId") String userId){
        log.info("user 정보 조회 호출");
        try{
            int userIdx = userService.userIdxLoad(userId);
            UserDTO userInfo = userService.getUserInfo(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(userInfo);
        } catch (Exception e) {
            log.error("회원 정보 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("")
    public ResponseEntity<UserDTO> updateUserInfo(@RequestHeader("userId") String userId,
                                                  @RequestBody UserDTO userDTO){
        log.info("user 정보 수정 호출");
        try{
            int userIdx = userService.userIdxLoad(userId);
            userDTO.setUserIdx(userIdx);
            userService.updateUserInfo(userDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.error("회원 정보 수정 실패: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* 관심 분야 설정
    < 로직 구현 고민 점 >
        - 회원 가입 시에 관심 분야 미설정 한 경우 있으므로 insert, update 확인 필요
        - client에서 요청을 다르게 하는 것이 좋은가?
        - server에서 db 확인해서 다르게 insert or update 하는 것이 좋은가?
    */
    @PostMapping("/fav")
    public ResponseEntity<String> setFavCategory(@RequestHeader("userId") String userId,
                                                 @RequestBody List<Integer> favList){
        log.info("user 관심 분야 설정 호출");
        try{
            int userIdx = userService.userIdxLoad(userId);
            Map<String, Object> params = new HashMap<>();
            params.put("userIdx", userIdx);
            params.put("favList", favList);
            userService.setFavCategory(params);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            log.error("user 관심 분야 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}