package com.sanitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.model.Pedido;
import com.sanitas.service.ConsumidorService;

@RestController
public class ConsumidorController {
	ConsumidorService service;

	public ConsumidorController(@Autowired ConsumidorService service) {
		super();
		this.service = service;
	}
	@GetMapping(value="ventas",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> ventas(){
		return service.recuperarVentas();
	}
	
}
