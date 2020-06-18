package com.lee.springcloudfeign.controller;

import com.lee.springcloudfeign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private HiService hiService;

    @RequestMapping("/sayHi")
    public String get(@RequestParam String name) {
        return hiService.hi(name);
    }
}
