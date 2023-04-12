package com.batch.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.batch.test.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ListenerService {

	@Autowired
	private UserService userService;

//	@KafkaListener(topics =  "${app.topic.batch}")
//	public void listenProducerMessage(@Payload List<User> record) {
//
//		log.info("All batch messages received");
//		for (int i = 0; i < record.size(); i++) {
//			log.info("Received message='{}'", record.get(i));
//		}
//		
//		userService.createUsers(record);
//		
//		
//	}

	@KafkaListener(id = "batch", topics = "${app.topic.batch}")
    public void receive(@Payload List<User> messages,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

		log.info("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		log.info("Starting the process to recieve batch messages");

        for (int i = 0; i < messages.size(); i++) {

        	log.info("received message='{}' with partition-offset='{}'",
                    messages.get(i), partitions.get(i) + "-" + offsets.get(i));

        }
        userService.createUsers(messages);
        log.info("all the batch messages are consumed");
    }
}
