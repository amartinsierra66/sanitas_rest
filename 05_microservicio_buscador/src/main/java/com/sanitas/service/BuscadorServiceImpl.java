package com.sanitas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sanitas.model.Pagina;


@Service(value = "buscadorServiceImpl")
public class BuscadorServiceImpl implements BuscadorService {
	List<Pagina> items=new ArrayList<>(List.of(new Pagina("Casa del libro","http://casadellibro.es", new String[]{"libros","lectura","ocio"},"Libros y m�s cosas"),
			new Pagina("La web del gamer","http://gamers.es", new String[]{"juegos","ordenadores","ocio"},"Todo sobre video juegos"),
			new Pagina("My computer","http://computerall.es", new String[]{"informática","ordenadores"},"Ordenadores al mejor precio"),
			new Pagina("Fnac","http://fnac.es", new String[]{"juegos","ordenadores","libros"},"Bienvenido al mundo del ocio y la cultura"),
			new Pagina("Todo pelis","http://filmers.es", new String[]{"cine","peliculas","ocio"},"Entra en el mundo del cine")));
	
	
	@Override
	public List<Pagina> buscarPorTematica(String clave){
		return items.stream()
		.filter(p->Arrays.stream(p.getClaves())
						 .anyMatch(c->c.equals(clave)))
		.collect(Collectors.toList());
	}


	@Override
	public void agregarPagina(Pagina pagina) {
		items.add(pagina);
		
	}
	@Override
	public void eliminarPagina(String nombre) {
		items.removeIf(p->p.getNombre().equals(nombre));		
	}


	@Override
	public List<Pagina> recuperarTodas() {
		return items;
	}
	
}
