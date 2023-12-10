package com.example.teamfresh.appPush.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    @KafkaListener(topics = "topic", groupId = "group_1")
    public void listener(Object data) {
        System.out.println("##################################################");
        System.out.println("##################################################");
        System.out.println("##################################################");
        System.out.println("##################################################");
        System.out.println("Received data: ");
        System.out.println(data);
        System.out.println("##################################################");
        System.out.println("##################################################");
        System.out.println("##################################################");

    }
}