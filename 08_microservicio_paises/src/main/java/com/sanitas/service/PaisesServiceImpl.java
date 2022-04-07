package com.sanitas.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanitas.dtos.PaisDto;
@Service
public class PaisesServiceImpl implements PaisesService {
	@Autowired
	RestTemplate template;
	String url="https://restcountries.com/v2/all";
	PaisDto[] paises;
	@PostConstruct
	public void init(){
	
		paises= template.getForObject(url, PaisDto[].class);
				
	}
	@Override
	public List<String> continentes() {
		return Arrays.stream(paises)
		.map(p->p.getContinente())
		.distinct()
		.collect(Collectors.toList());
	}

	@Override
	public List<PaisDto> paisesContinente(String continente) {
		return Arrays.stream(paises)
				.filter(p->p.getContinente().equals(continente))
				.collect(Collectors.toList());
	}
	@Override
	public long poblacionPais(String pais) {
		return Arrays.stream(paises)
				.filter(p->p.getPais().equals(pais))
				.findFirst()
				.orElse(new PaisDto()) //PaisDto
				.getHabitantes();
				
	}

	

}
