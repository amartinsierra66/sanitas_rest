package com.sanitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.dtos.StudentDto;
import com.sanitas.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	@GetMapping(value="estudiantes/{nota}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StudentDto> alumnosNota(@PathVariable("nota") double nota){
		return studentService.estudiantesNotaMinima(nota);
	}
	@PostMapping(value="estudiante",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void nuevoAlumno(@RequestBody StudentDto student) {
		studentService.altaEstudiantes(student);
	}
}
