package com.ssafy.devoca.board.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardDTO {
    private String userNickname;
    private String userId;
    private Integer userIdx;
    private Integer boardId;
    private String boardTitle;
    private String boardContent;
    private Integer boardType;
    private Timestamp boardDate;
    private String updateYN; // 수정 이력 여부
}