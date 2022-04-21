package com.sanitas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.converters.ActividadConverter;
import com.sanitas.dao.ActividadDao;
import com.sanitas.dtos.ActividadDto;
import com.sanitas.model.Actividad;
@Service
public class ActividadesServiceImpl implements ActividadesService {
	@Autowired
	ActividadDao actividadDao;
	@Autowired
	ActividadConverter converter;
	@Override
	public void actaActividad(ActividadDto actividad) {
		Optional<Actividad> op=actividadDao.findByIpOrigenAndRecursoAndFecha(actividad.getIpOrigen(), actividad.getRecurso(), actividad.getFecha());
		if(!op.isPresent()) {
			actividadDao.save(converter.dtoToActividad(actividad));
			
		}
		Actividad existente=op.get();
		existente.setTiempo(existente.getTiempo()+actividad.getTiempo());
		actividadDao.save(existente);
		
	}

	@Override
	public List<ActividadDto> actividades() {
		return actividadDao.findAll()
				.stream()
				.map(a->converter.actividadToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActividadDto> actividadesIp(String ip) {
		return actividadDao.findByIpOrigen(ip)
				.stream()
				.map(a->converter.actividadToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActividadDto> actividadesRecurso(String recurso) {
		return actividadDao.findByRecurso(recurso)
				.stream()
				.map(a->converter.actividadToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public int eliminarActividadesIp(String ip) {
		return actividadDao.deleteByIpOrigen(ip);
	}

}
