package com.sanitas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.converters.AlumnoConverter;
import com.sanitas.dao.AlumnosDao;
import com.sanitas.dtos.AlumnoDto;

@Service
public class AlumnosServiceImpl implements AlumnosService {	
	@Autowired
	AlumnoConverter alumnoConverter;
	@Autowired
	AlumnosDao alumnosDao;
	@Override
	public boolean altaAlumno(AlumnoDto alumno) {
		if(alumnosDao.findByNombre(alumno.getNombre()).isEmpty()) {
			alumnosDao.save(alumnoConverter.dtoToAlumno(alumno));
			return true;
		}
		return false;
	}

	

	@Override
	public List<AlumnoDto> alumnosCurso(String curso) {
		return alumnosDao.findByCurso(curso)
				.stream()
				.map(a->alumnoConverter.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public void eliminarAlumno(String nombre) {
		alumnosDao.deleteByNombre(nombre);
		
	}

	@Override
	public List<AlumnoDto> todosAlumnos() {
		return alumnosDao.findAll()
				.stream()
				.map(a->alumnoConverter.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public void actualizarAlumno(AlumnoDto alumno) {
		alumnosDao.save(alumnoConverter.dtoToAlumno(alumno));
	}



	@Override
	public void printNombresNotas(String curso) {
		List<Object[]> res=alumnosDao.findNombresNota(curso);
		res.forEach(item->System.out.println(item[0].toString()+":"+(Double)item[1]));
		
	}

}
