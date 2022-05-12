package com.sanitas.service;

import java.util.List;

import com.sanitas.dtos.ActividadDto;

public interface ActividadesService {
	void actaActividad(ActividadDto actividad);
	List<ActividadDto> actividades();
	List<ActividadDto> actividadesIp(String ip);
	List<ActividadDto> actividadesRecurso(String recurso);
	int eliminarActividadesIp(String ip);
}
