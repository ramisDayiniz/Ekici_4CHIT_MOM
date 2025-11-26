package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FeedbackConsumer {
    @KafkaListener(topics = "warehouse-reserve")
    public void receiveFeedback(String feedback) {
        System.out.println("Received feedback: " + feedback);
    }
}
