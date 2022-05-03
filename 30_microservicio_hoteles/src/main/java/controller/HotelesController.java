package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import service.HotelesService;

@CrossOrigin("*")
@RestController
public class HotelesController {
	@Autowired
	HotelesService hotelesService;
	//@Value("#{spring.application.name}")
	String data;
	
    @GetMapping(value="Hoteles",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Hotel>> hoteleDisponible(){
    	
		return new ResponseEntity<List<Hotel>>(hotelesService.hotelesDisponibles(),HttpStatus.OK);
	}
    
    @GetMapping(value="Hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
   	public ResponseEntity<Hotel> hotelNombre(@PathVariable("nombre") String nombre){
   		return new ResponseEntity<Hotel>(hotelesService.hotel(nombre),HttpStatus.OK);
   	}
	
}

