package com.ssafy.devoca.comment.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {
    private int boardId;
    private int commentId;

    private String userId;
    private String userImg;
    private String userNickName;

    private String commentContent;
    private Boolean commentPicked;
    private Timestamp commentRegistDate;
}
