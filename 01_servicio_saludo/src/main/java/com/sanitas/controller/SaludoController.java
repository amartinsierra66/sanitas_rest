package com.sanitas.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	@GetMapping(value="saludo",produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Bienvenido a REST";
	}
	
	@GetMapping(value="saludo/{name}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludarPersonalizado(@PathVariable("name") String nombre) {
		return "Bienvenido a REST sr./a "+nombre;
	}
	
	/*@GetMapping(value="saludo/{name}/{edad}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludarEdad(@PathVariable("name") String nombre, @PathVariable("edad") int edad) {
		return nombre+ " tienes "+edad+" años";
	}*/
	@GetMapping(value="saludoParam",produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludarEdad(@RequestParam("name") String nombre, @RequestParam("edad") int edad) {
		return nombre+ " tienes "+edad+" años";
	}
}
