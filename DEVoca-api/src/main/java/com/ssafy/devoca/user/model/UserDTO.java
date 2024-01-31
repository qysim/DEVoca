package com.ssafy.devoca.user.model;

import lombok.Data;

import java.sql.Time;
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
}
