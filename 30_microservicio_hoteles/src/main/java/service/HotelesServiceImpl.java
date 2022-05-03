package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {
	@Autowired
	HotelesDao hotelesDao;

	@Override
	public List<Hotel> hotelesDisponibles() {
		return hotelesDao.findByDisponible();
	}

	@Override
	public Hotel hotel(String nombre) {
		return hotelesDao.findByNombre(nombre);
	}

}
