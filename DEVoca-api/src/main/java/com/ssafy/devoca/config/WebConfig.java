package com.ssafy.devoca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173", "https://i10d112.p.ssafy.io"
                        ,"https://i10d112.p.ssafy.io/devoca/kakao/callback"
                        ,"https://kauth.kakao.com" ,"https://accounts.kakao.com") // 허용할 출처
                .allowedHeaders("Authorization", "Cache-Control", "Content-Type")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // 허용할 HTTP method
                .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }

}
