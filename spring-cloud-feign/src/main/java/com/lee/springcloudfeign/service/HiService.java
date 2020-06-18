package com.lee.springcloudfeign.service;


import com.lee.springcloudfeign.service.impl.FallBackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "config-feign-client", fallback = FallBackServiceImpl.class)
public interface HiService {
    @RequestMapping("hi")
    String hi(@RequestParam(name = "name") String name);
}
