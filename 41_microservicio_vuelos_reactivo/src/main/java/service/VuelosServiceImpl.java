package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.VuelosDao;
import model.Vuelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class VuelosServiceImpl implements VuelosService {
	@Autowired
	VuelosDao vuelosDao;
	@Override
	public Flux<Vuelo> recuperarVuelosDisponibles(int plazas) {
		return vuelosDao.findDisponibles(plazas);
	}
	@Override
	public Mono<Boolean> actualizarPlazas(int id, int plazas) {
		Mono<Vuelo> mono = vuelosDao.findById(id);
		return mono.map(v->{
			if(v.getPlazas()>=plazas) {
				v.setPlazas(v.getPlazas()-plazas);
				vuelosDao.save(v);	
				return true;
			}
			return false;
		});
		

	}

}
