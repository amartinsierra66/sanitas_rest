package com.sanitas.service;

import java.util.List;

import com.sanitas.dtos.AlumnoDto;

public interface AlumnosService {
	boolean altaAlumno(AlumnoDto alumno);
	void eliminarAlumno(String nombre);
	List<AlumnoDto> alumnosCurso(String curso);
	List<AlumnoDto> todosAlumnos();
	void actualizarAlumno(AlumnoDto alumno);
	void printNombresNotas(String curso);
}
