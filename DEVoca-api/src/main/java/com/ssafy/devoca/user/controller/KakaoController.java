package com.ssafy.devoca.user.controller;

import com.ssafy.devoca.user.model.KakaoDTO;
import com.ssafy.devoca.user.service.KakaoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("kakao")
public class KakaoController {
    //https://kauth.kakao.com/oauth/authorize?client_id=xxx&redirect_uri=xxx&response_type=code&state=리다이렉트 URL로 넘겨야 하는 값

    private final KakaoService kakaoService;
    // Redirect URI = http://localhost/kakao/callback 인증 코드를 전달 받는 URI
    @GetMapping("/callback")
    public ResponseEntity<KakaoDTO> callback(HttpServletRequest request) throws Exception {
        // "code" 가 카카오에서 전달해준 인증 코드
        KakaoDTO kakaoInfo = kakaoService.getKakaoInfo(request.getParameter("code"));

        return ResponseEntity.ok()
                .body(kakaoInfo);
    }

}
