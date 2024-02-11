package com.ssafy.devoca.board.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardDTO {
    private String boardTitle;
    private String boardContent;
    private Integer boardType;
    private Timestamp boardRegistDate;
    private Timestamp boardUpdateDate;
    private String userNickname;
    private String userId;
    private Integer userIdx;
}