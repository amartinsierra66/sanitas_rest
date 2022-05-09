package com.sanitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {
	String url="http://localhost:8080/cursos";
	@Autowired
	WebClient client;
	@Override
	public Mono<Boolean> procesarRespuesta() {
		Flux<String> flux=client
							.get()
							.uri(url)
							.accept(MediaType.TEXT_EVENT_STREAM)
							.retrieve()
							.bodyToFlux(String.class);
		flux.subscribe(System.out::println);
		return Mono.just(true);

	}

}
