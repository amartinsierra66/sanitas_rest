package com.sanitas.converters;

import com.sanitas.dtos.AlumnoDto;
import com.sanitas.model.Alumno;

public interface AlumnoConverter {
	AlumnoDto alumnoToDto(Alumno alumno);
	Alumno dtoToAlumno(AlumnoDto dto);
}
