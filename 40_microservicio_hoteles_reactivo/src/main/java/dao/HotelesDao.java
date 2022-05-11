package dao;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import model.Hotel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HotelesDao extends ReactiveCrudRepository<Hotel, Integer> {
	@Query ("select * from hoteles where disponible=1")
	Flux<Hotel> findByDisponible();
	Mono<Hotel> findByNombre(String nombre);

}
