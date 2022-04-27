package com.sanitas.converters;

import org.springframework.stereotype.Component;

import com.sanitas.dtos.ActividadDto;
import com.sanitas.model.Actividad;
@Component
public class ActividadConverterImpl implements ActividadConverter {

	@Override
	public ActividadDto actividadToDto(Actividad actividad) {
		return new ActividadDto(actividad.getIpOrigen(),actividad.getRecurso(),actividad.getTiempo(),actividad.getFecha());
	}

	@Override
	public Actividad dtoToActividad(ActividadDto dto) {
		return new Actividad(0,dto.getIpOrigen(),dto.getRecurso(),dto.getTiempo(),dto.getFecha());
	}

	

}
