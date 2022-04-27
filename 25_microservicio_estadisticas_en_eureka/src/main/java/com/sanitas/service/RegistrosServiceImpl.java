package com.sanitas.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanitas.converters.ActividadConverter;
import com.sanitas.dtos.CredentialsDto;
import com.sanitas.dtos.RegistroDto;
import com.sanitas.model.Actividad;

@Service
public class RegistrosServiceImpl implements RegistrosService {
	@Autowired
	RestTemplate template;
	@Autowired
	ActividadConverter converter;
	String url="http://servicio-seguimiento/seguimiento/";
	
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
	public List<String> ips() {
		if(token==null) {
			init();
		}
		HttpEntity<?> entity=new HttpEntity<>(null, getHeaders());

		return Arrays.stream(template.exchange(url+"actividades",
										HttpMethod.GET,
										entity,
										Actividad[].class).getBody())
				.map(a->a.getIpOrigen())
				.distinct()
				.collect(Collectors.toList());
				
	}

	@Override
	public List<RegistroDto> registrosFecha(Date fecha) {
		if(token==null) {
			init();
		}
		HttpEntity<?> entity=new HttpEntity<>(null, getHeaders());
		return Arrays.stream(template.exchange(url+"actividades",
								HttpMethod.GET,
								entity,
								Actividad[].class).getBody())
		.filter(a->a.getFecha().equals(fecha))
		.map(a->converter.actividadToDto(a, multiple(a.getIpOrigen(),fecha)))
		.collect(Collectors.toList());
	}

	private boolean multiple(String ip, Date fecha) {
		if(token==null) {
			init();
		}
		HttpEntity<?> entity=new HttpEntity<>(null, getHeaders());
		return Arrays.stream(template.exchange(url+"actividades/{ip}",
								HttpMethod.GET,
								entity,
								Actividad[].class,
								ip).getBody())
		.filter(a->a.getFecha().equals(fecha))
		.count()>1;
	}
	@Override
	public List<RegistroDto> registrosPorIp(String ip) {
		if(token==null) {
			init();
		}
		HttpEntity<?> entity=new HttpEntity<>(null, getHeaders());
		return Arrays.stream(template.exchange(url+"actividades/{ip}",
									HttpMethod.GET,
									entity,
									Actividad[].class,
									ip).getBody())
				.map(a->converter.actividadToDto(a, multiple(a.getIpOrigen(),a.getFecha())))
				.collect(Collectors.toList());		
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization", "Bearer "+token);
		return headers;
	}

}
