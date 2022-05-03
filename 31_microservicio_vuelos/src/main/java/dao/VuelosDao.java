package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Vuelo;

public interface VuelosDao extends JpaRepository<Vuelo,Integer>{
	@Query("select v from Vuelo v where v.plazas>=?1")
	List<Vuelo> findDisponibles(int plazas);
	
	//List<Vuelo> findByPlazasGreaterThanEqual(int plazas);
	
	

}
