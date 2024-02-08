package com.ssafy.devoca.dm.model;

import lombok.Data;

@Data
public class DmDTO {
    private String sendUserId;
    private String dmContent;
    private String dmSendDate;
    private Boolean dmBattleYN;
}
