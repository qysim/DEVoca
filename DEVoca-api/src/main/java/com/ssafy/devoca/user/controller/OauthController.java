package com.ssafy.devoca.user.controller;

import com.ssafy.devoca.user.service.OauthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user/login")
public class OauthController {

    private final OauthService oauthService;
    @GetMapping("/kakao")
    public void kakaoLogin(HttpServletResponse response) throws Exception{
        String kakaoLoginURL = oauthService.getKakaoLogin();
        response.sendRedirect(kakaoLoginURL);
    }

}
