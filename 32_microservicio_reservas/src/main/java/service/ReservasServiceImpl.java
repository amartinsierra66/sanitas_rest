package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;

@Service
public class ReservasServiceImpl implements ReservasService {
	@Autowired
	ReservasDao reservasDao;
	
	@Autowired
	RestTemplate template;
	//dirección "virtual" para acceder a través de eureka al servicio
	String urlVuelos="http://servicio-vuelos/";

	@Override
	public void reservar(Reserva reserva, int plazas) {
		reservasDao.save(reserva);
		template.put(urlVuelos+"Vuelo/{id}/{plazas}", null,reserva.getVuelo(),plazas);
	}

	@Override
	public List<Reserva> reservas() {
		return reservasDao.findAll();
	}

}
