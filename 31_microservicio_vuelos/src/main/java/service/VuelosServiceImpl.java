package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;
@Service
public class VuelosServiceImpl implements VuelosService {
	@Autowired
	VuelosDao vuelosDao;
	@Override
	public List<Vuelo> recuperarVuelosDisponibles(int plazas) {
		return vuelosDao.findDisponibles(plazas);
	}

	@Override
	public boolean actualizarPlazas(int id, int plazas) {
		Vuelo vuelo = vuelosDao.findById(id).get();
		if(vuelo.getPlazas()>=plazas) {
			vuelo.setPlazas(vuelo.getPlazas()-plazas);
			vuelosDao.save(vuelo);
			return true;
		}
		return false;

	}

}
