//package com.ssafy.devoca.config;
//
//import com.ssafy.devoca.dm.service.RedisSubscriber;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * Redis 설정
// *
// * @author kimjuyi
// */
//@Configuration
//public class RedisConfig {
//
//    // Redis 메시지 리스너 컨테이너
//    @Bean
//    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory,
//                                                                       MessageListenerAdapter messageListenerAdapter,
//                                                                       ChannelTopic channelTopic) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(messageListenerAdapter, channelTopic);
//        return container;
//    }
//
//    // Redis 메시지 리스너 어댑터 생성
//    @Bean
//    public MessageListenerAdapter messageListenerAdapter(RedisSubscriber redisSubscriber) {
//        return new MessageListenerAdapter(redisSubscriber, "onMessage");
//    }
//
//    // RedisTemplate 생성
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate (RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));
//
//        return redisTemplate;
//    }
//
//    // ChannelTopic 생성
//    @Bean
//    public ChannelTopic channelTopic() {
//        return new ChannelTopic("chatroom");
//    }
//}
