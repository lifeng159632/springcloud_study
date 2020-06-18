package com.lee.springcloudribbon.controller;

import com.lee.springcloudribbon.service.HelloRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRibbonController {
    @Autowired
    private HelloRibbonService helloRibbonService;

    @RequestMapping("get")
    public String get(@RequestParam String name) {
        return helloRibbonService.get(name);
    }
}
