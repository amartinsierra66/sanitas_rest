package com.sanitas.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.dtos.PersonaDto;

@RestController
public class PersonasController {
	@GetMapping(value="ficha/{nombre}",produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonaDto fichaPersona(@PathVariable("nombre") String name) {
		return new PersonaDto(name,"mayemail@gmail.com",33);
	}
	
	@GetMapping(value="fichaXml/{nombre}",produces = MediaType.APPLICATION_XML_VALUE)
	public PersonaDto fichaPersonaXml(@PathVariable("nombre") String name) {
		return new PersonaDto(name,"mayemail@gmail.com",33);
	}
}
