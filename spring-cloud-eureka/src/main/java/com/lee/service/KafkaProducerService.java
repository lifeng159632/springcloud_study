package com.lee.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaProducerService {


    public void product() {
        Properties kafkaPropertie = new Properties();
        kafkaPropertie.put("bootstrap.servers", "192.168.56.251:9092,192.168.56.252:9092,192.168.56.253:9092");
        kafkaPropertie.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaPropertie.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer kafkaProducer = new KafkaProducer(kafkaPropertie);

        for (int i = 0; i < 5; i++) {
            ProducerRecord record = new ProducerRecord("test_order","domain" + i,"www.f2time.com" + i);

            kafkaProducer.send(record);
        }
    }
}
