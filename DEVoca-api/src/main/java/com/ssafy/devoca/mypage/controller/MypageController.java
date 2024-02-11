package com.ssafy.devoca.mypage.controller;

import com.ssafy.devoca.mypage.service.MypageService;
import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.FavCategoryDTO;
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
@RequestMapping("/mypage")
@Slf4j
public class MypageController {

    private final MypageService mypageService;
    private final UserService userService;


    @GetMapping("/badge")
    public ResponseEntity<List<BadgeDTO>> getUserBadges(@RequestHeader("token") String token) {
        log.info("회원의 배지 목록 조회 호출");
        try{
            int userIdx = userService.loadUserIdx(token);
            List<BadgeDTO> badgeList = mypageService.getUserBadges(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(badgeList);
        } catch (Exception e){
            log.error("회원의 배지 목록 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*
     * 팔로우 하기 api
     * @author Ryu jiyun
     * */
    @GetMapping("/follow/{followId}")
    public ResponseEntity<String> followUser(@RequestHeader("token") String token
                                            ,@PathVariable("followId") String followId){
        log.info("팔로우 api 호출 : {}", followId);
        try{
            int userIdx = userService.loadUserIdx(token);
            int followIdx = userService.loadUserIdxById(followId);
            log.info("userIdx : {}, followIdx : {}", userIdx, followIdx);
            mypageService.followUser(userIdx, followIdx);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            log.debug("팔로우 api 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*
     * 팔로우 취소 api
     * @author Ryu jiyun
     * */
    @DeleteMapping("/unfollow/{followId}")
    public ResponseEntity<String> unfollowUser(@RequestHeader("token") String token
                                                ,@PathVariable("followId") String followId){
        log.info("팔로우 취소 api 호출 : {}", followId);
        try{
            int userIdx = userService.loadUserIdx(token);
            int followIdx = userService.loadUserIdxById(followId);
            mypageService.unfollowUser(userIdx, followIdx);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            log.debug("언팔로우 api 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/follower")
    public ResponseEntity<List<UserDTO>> getFollowList(@RequestHeader("token") String token){
        log.info("회원의 팔로워 목록 조회 호출 : 나를 팔로우하는 사람들");
        try{
            int userIdx = userService.loadUserIdx(token);
            List<UserDTO> followerList = mypageService.getFollowList(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(followerList);
        } catch (Exception e){
            log.error("회원의 팔로워 목록 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/following")
    public ResponseEntity<List<UserDTO>> getFollowingList(@RequestHeader("token") String token){
        log.info("회원의 팔로잉 목록 조회 호출 : 내가 팔로우 하는 사람들");
        try{
            int userIdx = userService.loadUserIdx(token);
            List<UserDTO> followingList = mypageService.getFollowingList(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(followingList);
        } catch (Exception e){
            log.error("회원의 팔로잉 목록 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/recommend")
    public ResponseEntity<List<UserDTO>> recommendFollow(@RequestHeader("token") String token){
        log.info("팔로우 추천 호출");
        try{
            int userIdx = userService.loadUserIdx(token);
            List<UserDTO> recommendList = mypageService.recommendFollow(userIdx);
            return ResponseEntity.status(HttpStatus.OK).body(recommendList);
        } catch(Exception e){
            log.error("팔로우 추천 호출 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}