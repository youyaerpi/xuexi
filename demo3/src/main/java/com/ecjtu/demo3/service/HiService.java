package com.ecjtu.demo3.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "demo2" ,fallback = HiHystrix.class)
public interface HiService {
      @GetMapping("/hi")
      String sayHi(@RequestParam(value = "name") String name);
}
