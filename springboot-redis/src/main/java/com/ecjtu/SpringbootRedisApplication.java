package com.ecjtu;

import com.ecjtu.config.Receiver;
import com.ecjtu.config.StorageProperties;
import com.ecjtu.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringbootRedisApplication {
      private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

      public static void main(String[] args) throws Exception {
            SpringApplication.run(SpringbootRedisApplication.class, args);
//            StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
//            CountDownLatch latch = context.getBean(CountDownLatch.class);
//
//            logger.info("Sending message...");
//            template.convertAndSend("chat", "Hello from Redis!");
//
//            latch.await();
//
//            System.exit(0);

      }

      //      @Bean
//      Receiver receiver(CountDownLatch latch) {
//            return new Receiver(latch);
//      }
//
//      @Bean
//      CountDownLatch latch() {
//            return new CountDownLatch(1);
//      }
//
//      @Bean
//      StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
//            return new StringRedisTemplate(connectionFactory);
//      }
//
//      @Bean
//      RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//                                              MessageListenerAdapter listenerAdapter) {
//
//            RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//            container.setConnectionFactory(connectionFactory);
//            container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
//
//            return container;
//      }
//
//      @Bean
//      MessageListenerAdapter listenerAdapter(Receiver receiver) {
//            return new MessageListenerAdapter(receiver, "receiveMessage");
//      }
      @Bean
      CommandLineRunner init(StorageService storageService) {
            return (args) -> {
                  storageService.deleteAll();
                  storageService.init();
            };
      }
}
