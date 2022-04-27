package com.sanitas.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlumnoDto {
	private String nombre;
	private String curso;
	@JsonProperty("nota")
	private double calificacion;
	public AlumnoDto( String nombre, String curso, double calificacion) {
		super();
		
		this.nombre = nombre;
		this.curso = curso;
		this.calificacion = calificacion;
	}
	public AlumnoDto() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	
}
