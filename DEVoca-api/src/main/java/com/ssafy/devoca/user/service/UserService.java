package com.ssafy.devoca.user.service;

import com.ssafy.devoca.user.model.UserDTO;

public interface UserService {

    int userIdxLoad(String userId) throws Exception;
    void joinUser(UserDTO userDTO) throws Exception;
    UserDTO getUserInfo(int userIdx) throws Exception;
    void updateUserInfo(UserDTO userDTO) throws Exception;
}
