package com.ecjtu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program springboot-redis
 * @description:
 * @author: xiexiang
 * @create: 2018/10/12 17:33
 */
@Repository
public class RedisDao {
      @Autowired
      private StringRedisTemplate template;

      public void setKey(String key, String value) {
            ValueOperations<String, String> ops = template.opsForValue();
            ops.set(key, value, 1, TimeUnit.MINUTES);
      }

      public String getValue(String key) {
            ValueOperations<String, String> ops = this.template.opsForValue();
            return ops.get(key);
      }

}
