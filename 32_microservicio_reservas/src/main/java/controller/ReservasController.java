package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Reserva;
import service.ReservasService;

@RestController
@CrossOrigin("*")
public class ReservasController {
	@Autowired
	ReservasService reservasService;
	@PostMapping(value="Reserva/{plazas}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> altaReserva(@RequestBody Reserva reserva,@PathVariable("plazas") int plazas) {
		reservasService.reservar(reserva, plazas);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping(value="Reservas",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reserva>> reservas(){
		return new ResponseEntity<List<Reserva>>(reservasService.reservas(),HttpStatus.OK);
	}
	
}
