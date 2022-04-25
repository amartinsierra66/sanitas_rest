package com.sanitas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.dtos.RegistroDto;
import com.sanitas.service.RegistrosService;

@RestController
public class RegistrosController {
	@Autowired
	RegistrosService service;
	@GetMapping(value="ips",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> ips(){
		return service.ips();
	}
	@GetMapping(value="registrosip/{ip}",produces = MediaType.APPLICATION_JSON_VALUE)
	List<RegistroDto> registrosIp(@PathVariable("ip") String ip){
		return service.registrosPorIp(ip);
	}
	@GetMapping(value="registrosfecha/{fecha}",produces = MediaType.APPLICATION_JSON_VALUE)
	List<RegistroDto> registrosFecha(@PathVariable("fecha") String fecha){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return service.registrosFecha(sdf.parse(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
