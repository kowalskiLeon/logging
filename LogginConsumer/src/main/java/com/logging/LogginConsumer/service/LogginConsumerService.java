package com.logging.LogginConsumer.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.logging.LogginConsumer.config.LogginConsumer;
import com.logging.LogginEntities.LogginRecord;

@Service
public class LogginConsumerService {

	LogginConsumer logginConsumer;
	
	 public LogginConsumerService() {
		this.logginConsumer = new LogginConsumer();
	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = "napoleao-order-processed", partitions = { "1" }), containerFactory = "orderKafkaListenerContainerFactory")
    public void orderListener(LogginRecord order) {
        System.out.println("Received Message Consumer 01: " + order.name());
    }
	 
	 public List<String> getAllMessagesFromTopic(String topicName) {
	        List<String> messages = new ArrayList<>();
	        
	        KafkaConsumer<String, LogginRecord> consumer = logginConsumer.createTempConsumer();
	        
	        try {
	            consumer.subscribe(Collections.singletonList(topicName));
	            consumer.poll(Duration.ofMillis(100));
	            consumer.seekToBeginning(consumer.assignment());
	            ConsumerRecords<String, LogginRecord> records = consumer.poll(Duration.ofSeconds(5));
	            for (ConsumerRecord<String, LogginRecord> record : records) {
	                messages.add(record.value().toString());
	            }
	            
	        } finally {
	            consumer.close();
	        }
	        
	        return messages;
	    }
    
}
