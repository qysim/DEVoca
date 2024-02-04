package com.ssafy.devoca.user.service;

import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.FavCategoryDTO;
import com.ssafy.devoca.user.model.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {

    int loadUserIdx(String userId) throws Exception;
    void joinUser(UserDTO userDTO) throws Exception;
    UserDTO getUserInfo(int userIdx) throws Exception;
    void updateUserInfo(UserDTO userDTO) throws Exception;
    void updateFavCategory(Map<String, Object> params) throws Exception;
    void delFavCategory(int userIdx) throws Exception;
    void setFavCategory(Map<String, Object> params) throws Exception;
    List<FavCategoryDTO> getFavCategory(int userIdx) throws Exception;
    List<BadgeDTO> getUserBadges(int userIdx) throws Exception;
}
