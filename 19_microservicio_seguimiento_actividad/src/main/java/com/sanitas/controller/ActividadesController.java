package com.sanitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.dtos.ActividadDto;
import com.sanitas.service.ActividadesService;

@RestController
public class ActividadesController {
	@Autowired
	ActividadesService actividadesService;
	@PostMapping(value="actividad",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> altaActividad(ActividadDto actividad){
		actividadesService.actaActividad(actividad);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	@GetMapping(value="actividades",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ActividadDto>> actividades(){
		List<ActividadDto> resultado=actividadesService.actividades();
		if(resultado.size()>0) {
			return new ResponseEntity<>(resultado,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(resultado,HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping(value="actividades/{ip}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ActividadDto>> actividadesPorIp(@PathVariable("ip") String ip){
		List<ActividadDto> resultado=actividadesService.actividadesIp(ip);
		if(resultado.size()>0) {
			return new ResponseEntity<>(resultado,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(resultado,HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping(value="actividades/{recurso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ActividadDto>> actividadesPorRecurso(@PathVariable("recurso") String recurso){
		List<ActividadDto> resultado=actividadesService.actividadesRecurso(recurso);
		if(resultado.size()>0) {
			return new ResponseEntity<>(resultado,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(resultado,HttpStatus.NO_CONTENT);
		}
	}
	@DeleteMapping(value="actividad/{ip}")
	public ResponseEntity<?> eliminarPorIp(@PathVariable("ip") String ip){
		int valor=actividadesService.eliminarActividadesIp(ip);
		HttpHeaders headers=new HttpHeaders();
		headers.add("eliminados", valor+"");
		return new ResponseEntity<>(headers,HttpStatus.OK);
	}
}
