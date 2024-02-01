package com.ssafy.devoca.user.service;

import com.ssafy.devoca.user.model.UserDTO;

public interface UserService {

    void joinUser(UserDTO userDTO) throws Exception;
    UserDTO getUserInfo(int userIdx) throws Exception;
}
