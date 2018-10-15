package com.ecjtu.demo3.service;

import org.springframework.stereotype.Component;

/**
 * @program demo3
 * @description:
 * @author: xiexiang
 * @create: 2018/10/12 11:06
 */
@Component
public class HiHystrix implements HiService {
      @Override
      public String sayHi(String name) {
            return "sorry" + name + "服务调用失败";
      }
}
