package com.kafkaproducer.example.controllers;

import com.kafkaproducer.example.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("kafka")
public class UserController {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "kafka-example";

    @GetMapping("/publish/{message}")
    public ResponseEntity<Map<String, Object>> post(@PathVariable("message") String message) {

        kafkaTemplate.send(TOPIC, new User("Peter", "Technology", message, 20000L));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", true);
        responseMap.put("message", "Message: '" + message +"' Published successfully");

        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}