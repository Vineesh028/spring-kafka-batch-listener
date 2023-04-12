package com.batch.test.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch.test.model.User;
import com.batch.test.service.SenderService;

@RestController
@RequestMapping("/kafkaservice")
public class KafkaController {

	
	@Autowired
	private SenderService sender;
	
	
	@PostMapping("/user")
	public String sendMsg() {
		for (int i = 0; i < 8 ; i++) {
			sender.send(new User(UUID.randomUUID(),"name"+i, "nick name"+i, "email"+i));
		}
		
		return "success";
	}

}
