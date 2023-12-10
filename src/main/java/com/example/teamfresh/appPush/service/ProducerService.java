package com.example.teamfresh.appPush.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object data) {
        System.out.println("##################################################");
        System.out.println("##################################################");
        System.out.println("Sending data: "+ data);
        System.out.println("##################################################");
        System.out.println("##################################################");
        kafkaTemplate.send(topic, data);
    }
}
