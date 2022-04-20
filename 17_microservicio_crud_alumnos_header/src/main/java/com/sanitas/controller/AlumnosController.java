package com.sanitas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.dtos.AlumnoDto;
import com.sanitas.service.AlumnosService;

@CrossOrigin("*")
@RestController
public class AlumnosController {
	@Autowired
	AlumnosService alumnosService;
	@PostMapping(value="alumno",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoDto>> altaAlumno( @RequestBody AlumnoDto alumno) {		
		if(alumnosService.altaAlumno(alumno)) {
			return new ResponseEntity<>(alumnosService.alumnosCurso(alumno.getCurso()),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}		
	}
	
	@GetMapping(value="alumnos/{curso}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<AlumnoDto>> listadoAlumnos( @PathVariable("curso") String curso) {
		return new ResponseEntity<>(alumnosService.alumnosCurso(curso),HttpStatus.OK);
	}
	@GetMapping(value="alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoDto>> todosAlumnos() {
		return new ResponseEntity<>(alumnosService.todosAlumnos(),HttpStatus.OK);
	}
	@DeleteMapping(value="alumno/{nombre}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable("nombre") String nombre) {
		alumnosService.eliminarAlumno(nombre);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping(value="alumno")
	public ResponseEntity<?> actualizarAlumno(@RequestBody AlumnoDto alumno) {
		alumnosService.actualizarAlumno(alumno);
		HttpHeaders headers=new HttpHeaders();
		headers.add("hora_actualizacion", (new Date()).toString());
		return new ResponseEntity<>(headers,HttpStatus.OK);
	}
}
