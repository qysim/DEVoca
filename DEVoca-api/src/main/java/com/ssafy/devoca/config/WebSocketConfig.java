package com.ssafy.devoca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket 설정
 *
 * @author kimjuyi
 */
@Configuration
// WebSocket 활성화, 메시지 브로커 사용
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * STOMP 프로토콜을 사용하는 WebSocket 엔드포인트 등록
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("*");
    }

    /**
     * 메시지 브로커 구성
     *
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/sub");
//        registry.setApplicationDestinationPrefixes("/pub");

        // EC2 서버에 Redis 설치 후 아래 코드로 변경
        registry.enableStompBrokerRelay("/sub"); // STOMP 메시지 브로커 설정
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
