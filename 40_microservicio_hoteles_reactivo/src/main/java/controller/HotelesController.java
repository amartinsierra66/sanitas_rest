package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.HotelesService;

@CrossOrigin("*")
@RestController
public class HotelesController {
	@Autowired
	HotelesService hotelesService;
	//@Value("#{spring.application.name}")
	String data;
	
    @GetMapping(value="Hoteles",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<Hotel>> hoteleDisponible(){
    	
		return new ResponseEntity<Flux<Hotel>>(hotelesService.hotelesDisponibles(),HttpStatus.OK);
	}
    
    @GetMapping(value="Hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
   	public Mono<ResponseEntity<Hotel>> hotelNombre(@PathVariable("nombre") String nombre){
   		//return new ResponseEntity<Hotel>(hotelesService.hotel(nombre),HttpStatus.OK);
    	Mono<Hotel> mono=hotelesService.hotel(nombre);
    	return mono
    			.map(h->new ResponseEntity<Hotel>(h,HttpStatus.OK))
    			.defaultIfEmpty(new ResponseEntity<Hotel>(HttpStatus.CONFLICT));
   	}
	
}

