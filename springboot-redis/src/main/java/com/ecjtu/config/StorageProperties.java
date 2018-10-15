package com.ecjtu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program springboot-redis
 * @description:
 * @author: xiexiang
 * @create: 2018/10/15 10:08
 */
@ConfigurationProperties("storage")
public class StorageProperties {
      private String location = "upload-dir";
      public String getLocation() {
            return location;
      }
      public void setLocation(String location) {
            this.location = location;
      }


}
