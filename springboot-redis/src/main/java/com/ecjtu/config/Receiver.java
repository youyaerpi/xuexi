package com.ecjtu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @program springboot-redis
 * @description:
 * @author: xiexiang
 * @create: 2018/10/15 09:17
 */
public class Receiver {
      private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
      private CountDownLatch latch;

      @Autowired
      public Receiver(CountDownLatch latch) {
            this.latch = latch;
      }

      public void receiveMessage(String message) {
            logger.info("Received <" + message + ">");
            latch.countDown();
      }


}