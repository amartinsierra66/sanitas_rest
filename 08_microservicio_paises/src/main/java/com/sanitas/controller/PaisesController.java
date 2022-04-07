package com.sanitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.dtos.PaisDto;
import com.sanitas.service.PaisesService;
@CrossOrigin("*")
@RestController
public class PaisesController {
	@Autowired
	PaisesService service;
	@GetMapping(value="continentes",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.continentes();
	}
	@GetMapping(value="paises/{continente}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PaisDto> paisesContinente(@PathVariable("continente") String continente){
		return service.paisesContinente(continente);
	}
	@GetMapping(value="poblacion/{pais}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String poblacionPais(@PathVariable("pais") String pais){
		return String.valueOf(service.poblacionPais(pais));
	}
}
