package service;

import model.Hotel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HotelesService {
	Flux<Hotel> hotelesDisponibles();
	Mono<Hotel> hotel(String nombre);
}
