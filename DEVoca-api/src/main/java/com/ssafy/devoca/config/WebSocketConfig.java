//package com.ssafy.devoca.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
///**
// * WebSocket 설정
// *
// * @author kimjuyi
// */
//@Configuration
//// WebSocket 활성화, 메시지 브로커 사용
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Value("${spring.data.redis.host}")
//    private String redisHost;
//
//    @Value("${spring.data.redis.port}")
//    private int redisPort;
//
//    @Value("${spring.data.redis.username}")
//    private String redisUser;
//
//    @Value("${spring.data.redis.password}")
//    private String redisPwd;
//
//    /**
//     * STOMP 프로토콜을 사용하는 WebSocket 엔드포인트 등록
//     *
//     * @param registry
//     */
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/chat")
//                .setAllowedOrigins("*");
//    }
//
//    /**
//     * 메시지 브로커 구성
//     *
//     * @param registry
//     */
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
////        registry.enableSimpleBroker("/sub");
////        registry.setApplicationDestinationPrefixes("/pub");
//
//        // EC2 서버에 Redis 설치 후 아래 코드로 변경
//        registry.enableStompBrokerRelay("/sub") // STOMP 메시지 브로커 설정
//                .setRelayHost(redisHost) // Redis가 설치된 호스트
//                .setRelayPort(redisPort) // Redis의 Port
//                .setClientLogin(redisUser) // Redis의 로그인 정보
//                .setClientPasscode(redisPwd); // Redis의 패스워드 정보
//        registry.setApplicationDestinationPrefixes("/pub");
//    }
//}
