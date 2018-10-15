package com.ecjtu.demo3.controller;

import com.ecjtu.demo3.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program demo3
 * @description:
 * @author: xiexiang
 * @create: 2018/10/12 09:58
 */
@RestController

public class HiController {
      @Autowired
      private HiService hiService;

      @GetMapping("/hi")
      public String sayHi(@RequestParam("name") String name) {
            return hiService.sayHi(name);
      }


}
