package controller;

import java.util.List;

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
import service.VuelosService;

@CrossOrigin(origins="*")
@RestController
public class VuelosController {
	
	@Autowired
	VuelosService service;

	@GetMapping (value ="Vuelos/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vuelo>> devolverVuelos (@PathVariable("plazas") int plazas) {
		return new ResponseEntity<List<Vuelo>>(service.recuperarVuelosDisponibles(plazas),HttpStatus.OK);
		
	}

	@PutMapping (value= "Vuelo/{id}/{plazas}")
	public ResponseEntity<?> modificarVuelo (@PathVariable("id") int id,
			@PathVariable("plazas") int plazas) {
		if(service.actualizarPlazas(id, plazas)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
}

