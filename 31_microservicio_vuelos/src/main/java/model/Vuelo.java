package model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the vuelos database table.
 * 
 */

@Entity
@Table(name="vuelos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Vuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idvuelo;

	private String company;

	private String fecha;

	private int plazas;

	private double precio;

	

	

}