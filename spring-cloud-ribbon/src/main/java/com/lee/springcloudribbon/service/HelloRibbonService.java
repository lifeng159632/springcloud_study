package com.lee.springcloudribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloRibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorMethod")
    public String get(String name) {
        return restTemplate.getForObject("http://config-client/hi?name=" + name, String.class);
    }

    public String errorMethod(String name) {
        return  name + ",service error";
    }
}
