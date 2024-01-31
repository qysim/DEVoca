package com.ssafy.devoca.user.service;

import com.ssafy.devoca.user.model.UserDTO;

public interface UserService {

    public void joinUser(UserDTO userDTO) throws Exception;
}
