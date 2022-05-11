package model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the vuelos database table.
 * 
 */


@Table(value="vuelos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Vuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	private int idvuelo;

	private String company;

	private String fecha;

	private int plazas;

	private double precio;

	

	

}