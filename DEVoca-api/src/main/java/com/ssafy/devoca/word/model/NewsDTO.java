package com.ssafy.devoca.word.model;

import lombok.Data;

@Data
public class NewsDTO {
    String title;
    String originallink;
    String link;
    String description;
    String pubDate;
}
