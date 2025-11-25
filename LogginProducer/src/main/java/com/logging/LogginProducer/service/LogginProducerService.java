package com.logging.LogginProducer.service;

import org.springframework.stereotype.Service;
import com.logging.LogginEntities.LogginRecord;
import java.util.Random;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class LogginProducerService {
	
	private final KafkaTemplate<String, LogginRecord> kafkaTemplateOrder;

    private final Random random = new Random();

    public LogginProducerService(KafkaTemplate<String, LogginRecord> kafkaTemplateOrder) {
        this.kafkaTemplateOrder = kafkaTemplateOrder;
    }

    @SuppressWarnings("null")
    public void enviarMensagem(LogginRecord order) {
        int partition = random.nextInt(2);
        System.out.println("Sent message to partition: " + partition);
        System.out.println("Sending Order: " + order.name());
        kafkaTemplateOrder.send("napoleao-order-processed",partition, null, order);
    }

}
