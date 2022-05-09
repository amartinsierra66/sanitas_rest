package com.sanitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.model.Libro;
import com.sanitas.service.CursosService;

import reactor.core.publisher.Flux;
@CrossOrigin("*")
@RestController
public class CursosController {

	CursosService service;

	public CursosController(@Autowired CursosService service) {
		super();
		this.service = service;
	}
	@GetMapping(value="cursos", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> devolverCursos(){
		return service.cursos();
	}
	@GetMapping(value="libros", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Libro> devolverLibros(){
		return service.libros();
	}
	
}
