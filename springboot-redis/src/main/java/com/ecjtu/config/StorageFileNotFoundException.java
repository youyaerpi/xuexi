package com.ecjtu.config;

/**
 * @program springboot-redis
 * @description:
 * @author: xiexiang
 * @create: 2018/10/15 10:23
 */
public class StorageFileNotFoundException extends StorageException {
      public StorageFileNotFoundException(String message) {
            super(message);
      }

      public StorageFileNotFoundException(String message, Throwable cause) {
            super(message, cause);
      }
}
