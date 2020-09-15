package com.lee.controller;


import com.lee.service.KafkaProducerService;
import com.lee.service.KeyDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private KeyDBService keyDBService;

    @GetMapping("hello")
    public String hello() {
        return "hello eureka";
    }

    @GetMapping("kf")
    public String sendKafka() {
        kafkaProducerService.product();
        return "ok";
    }

    @GetMapping("key")
    public String sendKeyDB() {
        keyDBService.writeIntoKeyDB();
        return "ok";
    }

}
