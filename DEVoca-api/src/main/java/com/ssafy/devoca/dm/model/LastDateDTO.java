package com.ssafy.devoca.dm.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LastDateDTO {
    private int roomIdx;
    private String userId;
    private Timestamp lastDate;
}
