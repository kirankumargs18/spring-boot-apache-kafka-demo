package com.kirangs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirangs.kafka.KafkaProducer;
import com.kirangs.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user){
		kafkaProducer.sendObjectToTopic(user);
		return ResponseEntity.ok("Message sent successfully");
	}

}
