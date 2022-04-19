package com.sanitas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pagina {
	private String nombre;
	private String url;
	private String[] claves;
	private String descripcion;
	
	
	
}
