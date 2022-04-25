package com.sanitas.converters;

import org.springframework.stereotype.Component;

import com.sanitas.dtos.RegistroDto;
import com.sanitas.model.Actividad;
@Component
public class ActividadConverterImpl implements ActividadConverter {

	@Override
	public RegistroDto actividadToDto(Actividad actividad,boolean multiple) {
		return new RegistroDto(actividad.getIpOrigen(),
				actividad.getTiempo(),
				actividad.getFecha(),
				multiple);
	}
}
