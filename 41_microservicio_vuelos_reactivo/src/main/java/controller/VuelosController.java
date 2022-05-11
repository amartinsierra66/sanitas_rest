package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.VuelosService;

@CrossOrigin(origins="*")
@RestController
public class VuelosController {
	
	@Autowired
	VuelosService service;

	@GetMapping (value ="Vuelos/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flux<Vuelo>> devolverVuelos (@PathVariable("plazas") int plazas) {
		return new ResponseEntity<Flux<Vuelo>>(service.recuperarVuelosDisponibles(plazas),HttpStatus.OK);
		
	}

	@PutMapping (value= "Vuelo/{id}/{plazas}")
	public Mono<ResponseEntity<?>> modificarVuelo (@PathVariable("id") int id,
			@PathVariable("plazas") int plazas) {
		Mono<Boolean> mono=service.actualizarPlazas(id, plazas);
		return mono.map(r->r?new ResponseEntity<Void>(HttpStatus.OK):new ResponseEntity<Void>(HttpStatus.CONFLICT));
		
	}
	
}

