package com.example.demo;

import model.WarehouseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String, WarehouseData> kafkaTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestBody WarehouseData warehouseData) {
        kafkaTemplate.send("warehouse-wien", warehouseData);
        return "SUCCESS";
    }


    @GetMapping("/test")
    public String test() {
        return "Application is running!";
    }

}