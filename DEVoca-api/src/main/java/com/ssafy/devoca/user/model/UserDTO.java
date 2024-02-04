package com.ssafy.devoca.user.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDTO {
    private Integer userIdx;
    private String userId;
    private String userName;
    private String userBirth;
    private String userEmail;
    private String userNickname;
    private String userIntro;
    private Integer userExp;
    private String userImg;
    private Timestamp userJoinDate;
    private Timestamp userUpdateDate;
    private Timestamp userRevokeDate;
    private String userRefreshToken;

    // only response
    private Integer userFollowingCnt;
    private Integer userFollowerCnt;
    private Integer userBgCnt;

    // follow
    private String followingYn;
}
