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
    public int userIdxLoad(String userId) throws Exception {
        return userMapper.userIdxLoad(userId);
    }

    @Override
    public void joinUser(UserDTO userDTO) throws Exception {
        userMapper.joinUser(userDTO);
    }

    @Override
    public UserDTO getUserInfo(int userIdx) throws Exception {
        return userMapper.getUserInfo(userIdx);
    }

    @Override
    public void updateUserInfo(UserDTO userDTO) throws Exception {
        userMapper.updateUserInfo(userDTO);
    }
}
