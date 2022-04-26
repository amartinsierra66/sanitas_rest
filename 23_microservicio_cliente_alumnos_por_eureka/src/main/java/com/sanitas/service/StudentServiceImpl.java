package com.sanitas.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanitas.dtos.CredentialsDto;
import com.sanitas.dtos.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	RestTemplate template;
	
	String url="http://servicio-alumnos/crud_alumnos/";
	@Value("${user}")
	String user;
	@Value("${password}")
	String password;
	
	String token;
	
	public void init() {
		CredentialsDto credentials=new CredentialsDto(user, password);
		//nos autenticamos para obtener el token
		token=template.postForObject(url+"login", credentials, String.class);
		
	}

	@Override
	public List<StudentDto> estudiantesNotaMinima(double nota) {
		//si no tenemos token lo pedimos
		if(token==null) {
			init();
		}
		HttpEntity entity=new HttpEntity(null, getHeaders());
		ResponseEntity<StudentDto[]> respuesta=template.exchange(url+"alumnos", HttpMethod.GET, entity, StudentDto[].class);
		
		StudentDto[] estudiantes=respuesta.getBody();
		return Arrays.stream(estudiantes)
		.filter(e->e.getPuntuacion()>=nota)
		.collect(Collectors.toList());
	}

	@Override
	public void altaEstudiantes(StudentDto student) {
		//si no tenemos token lo pedimos
		if(token==null) {
			init();
		}
		HttpEntity<StudentDto> entity=new HttpEntity<>(student, getHeaders());
		template.exchange(url+"alumno", HttpMethod.POST,entity,Void.class);
		
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization", "Bearer "+token);
		return headers;
	}

}
