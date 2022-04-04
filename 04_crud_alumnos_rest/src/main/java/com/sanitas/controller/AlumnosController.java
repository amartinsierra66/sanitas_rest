package com.sanitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.dtos.AlumnoDto;
import com.sanitas.model.Alumno;
import com.sanitas.service.AlumnosService;
@CrossOrigin("*")
@RestController
public class AlumnosController {
	@Autowired
	AlumnosService alumnosService;
	@PostMapping(value="alta",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AlumnoDto> altaAlumno(@RequestBody AlumnoDto alumno) {		
		if(alumnosService.altaAlumno(alumno)) {
			return alumnosService.alumnosCurso(alumno.getCurso());
		}else {
			return null;
		}
		
	}	
	@GetMapping(value="alumnos/{curso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AlumnoDto> listadoAlumnos(@PathVariable("curso") String curso) {
		return alumnosService.alumnosCurso(curso);
	}
	@GetMapping(value="alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AlumnoDto> todosAlumnos() {
		return alumnosService.todosAlumnos();
	}
	@DeleteMapping(value="eliminar/{nombre}")
	public void eliminarAlumno(@PathVariable("nombre") String nombre) {
		alumnosService.eliminarAlumno(nombre);
	}
	@PutMapping(value="actualizar")
	public void actualizarAlumno(@RequestBody AlumnoDto alumno) {
		alumnosService.actualizarAlumno(alumno);
	}
}
