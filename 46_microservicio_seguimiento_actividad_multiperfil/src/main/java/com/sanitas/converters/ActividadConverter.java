package com.sanitas.converters;

import com.sanitas.dtos.ActividadDto;
import com.sanitas.model.Actividad;

public interface ActividadConverter {
	ActividadDto actividadToDto(Actividad actividad);
	Actividad dtoToActividad(ActividadDto dto);
}
