package com.sanitas.service;

import java.util.Date;
import java.util.List;

import com.sanitas.dtos.RegistroDto;

public interface RegistrosService {
	List<String> ips();
	List<RegistroDto> registrosFecha(Date fecha);
	List<RegistroDto> registrosPorIp(String ip);
}
