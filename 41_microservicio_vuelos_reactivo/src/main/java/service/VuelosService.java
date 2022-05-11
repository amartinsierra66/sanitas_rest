package service;

import model.Vuelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VuelosService {
	Flux<Vuelo> recuperarVuelosDisponibles(int plazas);
	Mono<Boolean> actualizarPlazas(int vuelo, int plazas);
}
