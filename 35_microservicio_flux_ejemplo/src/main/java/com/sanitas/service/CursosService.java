package com.sanitas.service;

import com.sanitas.model.Libro;

import reactor.core.publisher.Flux;

public interface CursosService {
	Flux<String> cursos();
	
	Flux<Libro> libros();
}
