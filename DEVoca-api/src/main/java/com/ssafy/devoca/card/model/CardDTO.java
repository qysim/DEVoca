package com.ssafy.devoca.card.model;

import lombok.Data;

@Data
public class CardDTO {
    // card 등록을 위한 dto
    private String userId;
    private int wordId;
    private String cardContent;
    private String cardLink;
    private int cardAccess;
}
