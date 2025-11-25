package com.logging.LogginConsumer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logging.LogginConsumer.service.LogginConsumerService;



@RestController
public class LogginConsumerController {
	
	LogginConsumerService consumerService;
	
	public LogginConsumerController(LogginConsumerService consumerService) {
		this.consumerService = consumerService;
	}

	@Value(value = "${spring.application.version}")
    private String version;

	@GetMapping("/versao")
	public  String obterVersao() {
		return version;
	}
	
	@GetMapping("/listar-all")
	public ResponseEntity<List<String>> listarMensagens() {
		ResponseEntity<List<String>> response;
		try {
			List<String> list = new ArrayList<>();
			list = consumerService.getAllMessagesFromTopic("napoleao-order-processed");
			response = new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
			return response;
		}catch(Exception e) {
			throw new Error(e);
		}
		
	}
	
}
