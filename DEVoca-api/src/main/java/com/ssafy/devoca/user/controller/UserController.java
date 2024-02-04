package com.ssafy.devoca.user.controller;

import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.FavCategoryDTO;
import com.ssafy.devoca.user.model.UserDTO;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
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
            int userIdx = userService.loadUserIdx(userId);
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
            int userIdx = userService.loadUserIdx(userId);
            userDTO.setUserIdx(userIdx);
            userService.updateUserInfo(userDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.error("회원 정보 수정 실패: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* 관심 분야 설정
        - delete 후 insert
    */
    @PutMapping("/fav")
    public ResponseEntity<String> updateFavCategory(@RequestHeader("userId") String userId,
                                                 @RequestBody List<Integer> favList){
        log.info("user 관심 분야 설정 호출");
        try{
            int userIdx = userService.loadUserIdx(userId);
            Map<String, Object> params = new HashMap<>();
            params.put("userIdx", userIdx);
            params.put("favList", favList);
            userService.updateFavCategory(params);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            log.error("user 관심 분야 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/fav")
    public ResponseEntity<List<FavCategoryDTO>> getFavCategory(@RequestHeader("userId") String userId){
        log.info("회원 관심 분야 조회 호출");
        try{
            int userIdx = userService.loadUserIdx(userId);
            List<FavCategoryDTO> favList = userService.getFavCategory(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(favList);
        } catch (Exception e){
            log.error("회원 관심 분야 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/badge")
    public ResponseEntity<List<BadgeDTO>> getUserBadges(@RequestHeader("userId") String userId) {
        log.info("회원의 배지 목록 조회 호출");
        try{
            int userIdx = userService.loadUserIdx(userId);
            List<BadgeDTO> badgeList = userService.getUserBadges(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(badgeList);
        } catch (Exception e){
            log.error("회원의 배지 목록 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/follower")
    public ResponseEntity<List<UserDTO>> getFollowList(@RequestHeader("userId") String userId){
        log.info("회원의 팔로워 목록 조회 호출 : 나를 팔로우하는 사람들");
        try{
            int userIdx = userService.loadUserIdx(userId);
            List<UserDTO> followerList = userService.getFollowList(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(followerList);
        } catch (Exception e){
            log.error("회원의 팔로워 목록 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/following")
    public ResponseEntity<List<UserDTO>> getFollowingList(@RequestHeader("userId") String userId){
        log.info("회원의 팔로잉 목록 조회 호출 : 내가 팔로우 하는 사람들");
        try{
            int userIdx = userService.loadUserIdx(userId);
            List<UserDTO> followingList = userService.getFollowingList(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(followingList);
        } catch (Exception e){
            log.error("회원의 팔로잉 목록 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/recommend")
    public ResponseEntity<List<UserDTO>> recommendFollow(@RequestHeader("userId") String userId){
        log.info("팔로우 추천 호출");
        try{
            int userIdx = userService.loadUserIdx(userId);
            List<UserDTO> recommendList = userService.recommendFollow(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(recommendList);
        } catch(Exception e){
            log.error("팔로우 추천 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}