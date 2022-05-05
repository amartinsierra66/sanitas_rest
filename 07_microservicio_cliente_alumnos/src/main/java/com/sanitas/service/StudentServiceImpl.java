package com.sanitas.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanitas.dtos.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	RestTemplate template;
	
	String url="http://localhost:9000/crud_alumnos/";

	@Override
	public List<StudentDto> estudiantesNotaMinima(double nota) {
		StudentDto[] estudiantes=template.getForObject(url+"alumnos", StudentDto[].class);
		return Arrays.stream(estudiantes)
		.filter(e->e.getPuntuacion()>=nota)
		.collect(Collectors.toList());
	}

	@Override
	public void altaEstudiantes(StudentDto student) {
		template.postForLocation(url+"alumno", student);
		
	}

}
