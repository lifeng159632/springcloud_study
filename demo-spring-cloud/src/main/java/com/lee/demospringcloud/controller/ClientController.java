package com.lee.demospringcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

//    @Value("${lee}")
    String testpath;

//    @Value("${foo}")
    String ss;
//    @Value("${server.port}")
    String port;
    @RequestMapping("hi")
    public String hi(@RequestParam String name) {
        return "hello " + name + ", service port: " + port;
    }
}

