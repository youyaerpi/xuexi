package com.ecjtu;

import com.ecjtu.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
      public static Logger logger = LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);

      @Test
      public void contextLoads() {
      }

      @Autowired(required = true)
      RedisDao redisDao;

      @Test
      public void testRedis() {
            redisDao.setKey("name", "xiexiang");
            redisDao.setKey("age", "21");
            logger.info(redisDao.getValue("name"));
            logger.info(redisDao.getValue("age"));
      }


}
