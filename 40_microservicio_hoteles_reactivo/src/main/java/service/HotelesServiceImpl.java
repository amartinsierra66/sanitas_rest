package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HotelesServiceImpl implements HotelesService {
	@Autowired
	HotelesDao hotelesDao;

	@Override
	public Flux<Hotel> hotelesDisponibles() {
		return hotelesDao.findByDisponible();
	}

	@Override
	public Mono<Hotel> hotel(String nombre) {
		return hotelesDao.findByNombre(nombre);
	}

}
