package com.ssafy.devoca.mypage.service;

import com.ssafy.devoca.mypage.model.mapper.MypageMapper;
import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.FavCategoryDTO;
import com.ssafy.devoca.user.model.UserDTO;
import com.ssafy.devoca.user.model.mapper.UserMapper;
import com.ssafy.devoca.user.service.UserService;
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
public class MypageServiceImpl implements MypageService {

    private final MypageMapper mypageMapper;

    @Override
    public List<BadgeDTO> getUserBadges(int userIdx) throws Exception {
        return mypageMapper.getUserBadges(userIdx);
    }

    @Override
    public void followUser(int userIdx, int followIdx) throws Exception {
        mypageMapper.followUser(userIdx, followIdx);
    }

    @Override
    public void unfollowUser(int userIdx, int followIdx) throws Exception {
        mypageMapper.unfollowUser(userIdx, followIdx);
    }

    @Override
    public List<UserDTO> getFollowList(int userIdx) throws Exception {
        return mypageMapper.getFollowList(userIdx);
    }

    @Override
    public List<UserDTO> getFollowingList(int userIdx) throws Exception {
        return mypageMapper.getFollowingList(userIdx);
    }

    @Override
    public List<UserDTO> recommendFollow(int userIdx) throws Exception {
        return mypageMapper.recommendFollow(userIdx);
    }



}
