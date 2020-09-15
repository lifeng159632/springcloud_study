package com.lee.demospringcloud.controller;

import com.lee.demospringcloud.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ClientController {
//
//    @Value("${lee}")
//    public String testpath;

    @Value("${foo}")
    public String ss;

    @Value("${server.port}")
    String port;

    @Autowired
    private BusinessService businessService;

    @RequestMapping("hi")
    public String hi(@RequestParam String name) {
        return "hello " + ss + ", service port: " + port;
    }

    @GetMapping("do")
    public String doServer() {

        businessService.doSomething();
        return "OK";
    }
}

