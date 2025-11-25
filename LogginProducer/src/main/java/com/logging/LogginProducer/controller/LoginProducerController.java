package com.logging.LogginProducer.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.logging.LogginEntities.LogginRecord;
import com.logging.LogginProducer.service.LogginProducerService;

@RestController
public class LoginProducerController {
	

	LogginProducerService producerService;
	
	public LoginProducerController(LogginProducerService producerService) {
		this.producerService = producerService;
	}

	@GetMapping("/versao")
	public static String obterVersao() {
		return "teste";
	}
	
	@PostMapping("/enviar")
	public String enviarMensagem(@RequestBody LogginRecord order) {
		ResponseEntity<LogginRecord> responseEntity;
		try {
			producerService.enviarMensagem(order);
		}
		catch(Exception e) {
			
		}
		return "teste-enviar";
	}
	
}
