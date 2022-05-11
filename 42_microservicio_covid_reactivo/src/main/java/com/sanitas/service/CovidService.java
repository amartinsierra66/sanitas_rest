package com.sanitas.service;

import com.sanitas.model.Item;

import reactor.core.publisher.Flux;

public interface CovidService {
	Flux<String> paises();
	Flux<Item> itemsPais(String pais);
}
