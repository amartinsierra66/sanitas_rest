package com.sanitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.model.Pagina;
import com.sanitas.service.BuscadorService;

@RestController
public class BuscadorController {
	@Autowired
	BuscadorService buscadorService;
	@GetMapping(value="buscar/{clave}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> paginasClave(@PathVariable("clave") String clave){
		return buscadorService.buscarPorTematica(clave);
	}
	@PostMapping(value="agregar",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_PLAIN_VALUE)
	public String nuevaPagina(@RequestBody Pagina pagina) {
		buscadorService.agregarPagina(pagina);
		return "Agregada página "+pagina.getNombre();
	}
	@DeleteMapping(value="eliminar/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> eliminarPagina(@PathVariable("name") String name) {
		buscadorService.eliminarPagina(name);
		return buscadorService.recuperarTodas();
	}
}
