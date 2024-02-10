package com.ssafy.devoca.comment.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {
    private int commentId;

    private String userId;
    private String userImg;

    private String commentContent;
    private Timestamp commentRegistDate;
}
