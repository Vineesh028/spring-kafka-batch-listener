package com.batch.test.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.batch.test.model.User;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class SenderService {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
  
    @Value("${app.topic.batch}")
    private String topic;
  
    public void send(User user){
    	
        log.info("Sending message='{}' to topic='{}'", user, topic);

        ProducerRecord<String, User> record = new ProducerRecord<>(topic, user);

        kafkaTemplate.send(record);        
    
    }
  

}
