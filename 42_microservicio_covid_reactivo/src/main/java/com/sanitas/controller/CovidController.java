package com.sanitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.model.Item;
import com.sanitas.service.CovidService;

import reactor.core.publisher.Flux;
@CrossOrigin("*")
@RestController
public class CovidController {
	@Autowired
	CovidService service;
	@GetMapping(value="paises",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> paises(){
		return service.paises();
	}
	@GetMapping(value="items/{pais}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Item> itemsPais(@PathVariable("pais") String pais){
		return service.itemsPais(pais);
	}
}
