package dao;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import model.Vuelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VuelosDao extends ReactiveCrudRepository<Vuelo,Integer>{
	@Query("select * from vuelos v where plazas>=?")
	Flux<Vuelo> findDisponibles(int plazas);
	
	/*@Transactional
	@Modifying
	@Query("update vuelos set plazas=plazas-? where idVuelo=?")
	Mono<Vuelo> save(int plazas,int idVuelo);*/
	
	//List<Vuelo> findByPlazasGreaterThanEqual(int plazas);
	
	

}
