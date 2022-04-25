package com.sanitas.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Actividad {
	private String ipOrigen;
	private String recurso;
	private int tiempo;
	private Date fecha;
}
