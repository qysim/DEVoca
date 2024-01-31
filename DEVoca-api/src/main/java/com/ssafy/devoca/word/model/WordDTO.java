package com.ssafy.devoca.word.model;

import lombok.Data;

import java.util.List;

@Data
public class WordDTO {
    int wordId;
    String wordNameKr;
    String wordNameEn;
    String wordDef;
    String wordSumm;
    String wordLink;
    List<String> wordCategory;
}
