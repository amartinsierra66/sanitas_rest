package model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Reserva implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idreserva;

	private String dni;

	private int hotel;

	private String nombre;

	private int vuelo;

	
}