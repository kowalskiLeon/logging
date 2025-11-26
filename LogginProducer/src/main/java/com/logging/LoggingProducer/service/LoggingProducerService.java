package com.logging.LoggingProducer.service;

import org.springframework.stereotype.Service;

import com.logging.LoggingEntities.LoggingRecord;

import java.util.Random;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class LoggingProducerService {
	
	private final KafkaTemplate<String, LoggingRecord> kafkaTemplateOrder;

    private final Random random = new Random();

    public LoggingProducerService(KafkaTemplate<String, LoggingRecord> kafkaTemplateOrder) {
        this.kafkaTemplateOrder = kafkaTemplateOrder;
    }

    @SuppressWarnings("null")
    public void enviarMensagem(LoggingRecord order) {
        int partition = random.nextInt(2);
        System.out.println("Sent message to partition: " + partition);
        System.out.println("Sending Order: " + order.name());
        kafkaTemplateOrder.send("napoleao-order-processed",partition, null, order);
    }

}
