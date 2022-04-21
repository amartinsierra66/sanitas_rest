package com.sanitas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "actividad")
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idactividad;
	private String ipOrigen;
	private String recurso;
	private int tiempo;
	private Date fecha;

}
