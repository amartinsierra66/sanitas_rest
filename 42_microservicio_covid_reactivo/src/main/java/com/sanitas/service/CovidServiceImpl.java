package com.sanitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sanitas.model.Item;

import reactor.core.publisher.Flux;
@Service
public class CovidServiceImpl implements CovidService {
	@Autowired
	//RestTemplate template;
	WebClient webClient;
	
	String url="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	
	/*private Item[] getItems() {
		return template.getForObject(url, Item[].class);
	}*/
	
	private Flux<Item> getItems(){
		return webClient
				.get()
				.uri(url)
				.retrieve()
				.bodyToFlux(Item.class);
	}

	@Override
	public Flux<String> paises() {
		return getItems()
		.map(it->it.getPais())
		.distinct();
	}

	@Override
	public Flux<Item> itemsPais(String pais) {
		return getItems()
				.filter(it->it.getPais().equals(pais));
	}

}
