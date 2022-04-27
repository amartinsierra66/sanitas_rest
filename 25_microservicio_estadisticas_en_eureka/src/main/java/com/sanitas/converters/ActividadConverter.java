package com.sanitas.converters;

import com.sanitas.dtos.RegistroDto;
import com.sanitas.model.Actividad;

public interface ActividadConverter {
	RegistroDto actividadToDto(Actividad actividad,boolean multiple);
	
}
