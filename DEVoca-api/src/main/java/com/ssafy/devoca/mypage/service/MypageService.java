package com.ssafy.devoca.mypage.service;

import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.FavCategoryDTO;
import com.ssafy.devoca.user.model.UserDTO;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface MypageService {

    List<BadgeDTO> getUserBadges(int userIdx) throws Exception;
    void followUser(int userIdx, int followIdx) throws Exception;
    void unfollowUser(int userIdx, int followIdx) throws Exception;
    List<UserDTO> getFollowList(int userIdx) throws Exception;
    List<UserDTO> getFollowingList(int userIdx) throws Exception;
    List<UserDTO> recommendFollow(int userIdx) throws Exception;
    void uploadProfileImg(String imgname, InputStream stream) throws Exception;
}
