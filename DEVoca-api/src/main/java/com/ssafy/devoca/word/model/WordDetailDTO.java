package com.ssafy.devoca.word.model;

import com.ssafy.devoca.card.model.CardDTO;
import lombok.Data;

import java.util.List;

@Data
public class WordDetailDTO {
    WordDTO wordDTO;
    List<NewsDTO> newsList;
    List<CardDTO> cardList;
}
