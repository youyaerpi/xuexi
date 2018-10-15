package com.ecjtu.config;

/**
 * @program springboot-redis
 * @description:
 * @author: xiexiang
 * @create: 2018/10/15 10:22
 */
public class StorageException extends RuntimeException {
      public StorageException(String message) {
            super(message);
      }

      public StorageException(String message, Throwable cause) {
            super(message, cause);
      }
}
