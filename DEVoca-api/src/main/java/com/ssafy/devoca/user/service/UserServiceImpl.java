package com.ssafy.devoca.user.service;

import com.ssafy.devoca.user.model.UserDTO;
import com.ssafy.devoca.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    @Override
    public void joinUser(UserDTO userDTO) throws Exception {
        userMapper.joinUser(userDTO);
    }
}
