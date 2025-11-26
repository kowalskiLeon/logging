package com.logging.LoggingConsumer.service;

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

import com.logging.LoggingConsumer.config.LoggingConsumer;
import com.logging.LoggingEntities.LoggingRecord;

@Service
public class LoggingConsumerService {

	LoggingConsumer logginConsumer;
	
	 public LoggingConsumerService() {
		this.logginConsumer = new LoggingConsumer();
	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = "napoleao-order-processed", partitions = { "1" }), containerFactory = "orderKafkaListenerContainerFactory")
    public void orderListener(LoggingRecord order) {
        System.out.println("Received Message Consumer 01: " + order.name());
    }
	 
	 public List<String> getAllMessagesFromTopic(String topicName) {
	        List<String> messages = new ArrayList<>();
	        
	        KafkaConsumer<String, LoggingRecord> consumer = logginConsumer.createTempConsumer();
	        
	        try {
	            consumer.subscribe(Collections.singletonList(topicName));
	            consumer.poll(Duration.ofMillis(100));
	            consumer.seekToBeginning(consumer.assignment());
	            ConsumerRecords<String, LoggingRecord> records = consumer.poll(Duration.ofSeconds(5));
	            for (ConsumerRecord<String, LoggingRecord> record : records) {
	                messages.add(record.value().toString());
	            }
	            
	        } finally {
	            consumer.close();
	        }
	        
	        return messages;
	    }
    
}
