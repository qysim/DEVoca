package com.ssafy.devoca.user.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KakaoDTO {

    private long id;
    private boolean userYn;

}
