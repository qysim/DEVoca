package com.ssafy.devoca.user.service;

import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.FavCategoryDTO;
import com.ssafy.devoca.user.model.UserDTO;
import com.ssafy.devoca.user.model.mapper.UserMapper;
import com.ssafy.devoca.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    @Override
    public int loadUserIdx(String token) throws Exception {
        String userId = "";
        if (jwtUtil.checkToken(token)){
            userId = jwtUtil.getUserId(token);
        } else {
            throw new Exception("Loading userId Fail");
        }
        log.info("userId : {}", userId);
        return userMapper.loadUserIdx(userId);
    }

    @Override
    public int loadUserIdxById(String userId) throws Exception {
        return userMapper.loadUserIdx(userId);
    }

    @Override
    @Transactional
    public String joinUser(UserDTO userDTO) throws Exception {
        userMapper.joinUser(userDTO);
        userMapper.getBadge(userDTO.getUserIdx(), 3);
        String accessToken = jwtUtil.createAccessToken(userDTO.getUserId());
        log.info("accessToken : {}", accessToken);
        return accessToken;
    }

    @Override
    public UserDTO getUserInfo(int userIdx) throws Exception {
        return userMapper.getUserInfo(userIdx);
    }

    @Override
    public void updateUserInfo(UserDTO userDTO) throws Exception {
        userMapper.updateUserInfo(userDTO);
    }

    @Override
    @Transactional
    public void updateFavCategory(Map<String, Object> params) throws Exception {
        delFavCategory((Integer) params.get("userIdx"));
        log.info("관심 분야 삭제 완료");
        setFavCategory(params);
        log.info("관심 분야 설정 완료");
    }

    @Override
    public void delFavCategory(int userIdx) throws Exception {
        userMapper.delFavCategory(userIdx);
    }

    @Override
    public void setFavCategory(Map<String, Object> params) throws Exception {
        userMapper.setFavCategory(params);
    }


    @Override
    public List<FavCategoryDTO> getFavCategory(int userIdx) throws Exception {
        return userMapper.getFavCategory(userIdx);
    }

    @Override
    public UserDTO getOtherUserInfo(int otherIdx, int userIdx) throws Exception {
        return userMapper.getOtherUserInfo(otherIdx, userIdx);
    }

    @Override
    public String getUserNickName(int userIdx) throws Exception {
        return userMapper.getUserNickName(userIdx);
    }

}
