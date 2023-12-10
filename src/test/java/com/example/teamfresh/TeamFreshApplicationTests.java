package com.example.teamfresh;

import com.example.teamfresh.appPush.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamFreshApplicationTests {

    @Autowired
    private ProducerService producerService;

    @Test
    void messageTest() {
        producerService.sendMessage("topic", "Hello World!");
    }

}
