package com.sanitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.service.ClienteService;

import reactor.core.publisher.Mono;

@RestController
public class ClienteController {
	ClienteService service;

	public ClienteController(@Autowired ClienteService service) {
		super();
		this.service = service;
	}
	@PostMapping(value="procesarCursos",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Boolean> procesar() {
		return service.procesarRespuesta();
	}
	
}
