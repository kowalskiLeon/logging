package com.logging.LoggingProducer.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.logging.LoggingEntities.LoggingRecord;
import com.logging.LoggingProducer.service.LoggingProducerService;




@RestController
public class LoggingProducerController {
	

	LoggingProducerService producerService;
	
	public LoggingProducerController(LoggingProducerService producerService) {
		this.producerService = producerService;
	}

	@GetMapping("/versao")
	public static String obterVersao() {
		return "teste";
	}
	
	@PostMapping("/enviar")
	public String enviarMensagem(@RequestBody LoggingRecord order) {
		ResponseEntity<LoggingRecord> responseEntity;
		try {
			producerService.enviarMensagem(order);
		}
		catch(Exception e) {
			
		}
		return "teste-enviar";
	}
	
}
