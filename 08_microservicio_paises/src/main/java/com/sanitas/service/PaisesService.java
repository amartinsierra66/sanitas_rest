package com.sanitas.service;

import java.util.List;

import com.sanitas.dtos.PaisDto;

public interface PaisesService {
	List<String> continentes();
	List<PaisDto> paisesContinente(String continente);
	long poblacionPais(String pais);
}
