package com.sanitas.service;

import java.util.List;

import com.sanitas.dtos.StudentDto;

public interface StudentService {
	List<StudentDto> estudiantesNotaMinima(double nota);
	void altaEstudiantes(StudentDto student);
}
