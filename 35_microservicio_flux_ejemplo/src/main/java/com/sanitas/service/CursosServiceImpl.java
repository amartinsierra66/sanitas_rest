package com.sanitas.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sanitas.model.Libro;

import reactor.core.publisher.Flux;
@Service
public class CursosServiceImpl implements CursosService {

	@Override
	public Flux<String> cursos() {
		// TODO Auto-generated method stub
		return Flux.just("Java 10","Spring Boot","Python","Angular","JPA")
				.delayElements(Duration.ofSeconds(3));
	}

	@Override
	public Flux<Libro> libros() {
		return Flux.fromIterable(getLibros());
	}
	//simula una capa DAO
	private List<Libro> getLibros(){
		List<Libro> libros=new ArrayList<>();
		for(int i=1;i<=3;i++) {
			libros.add(new Libro("aa "+i,"Titulo "+i,20));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return libros;
	}

}
