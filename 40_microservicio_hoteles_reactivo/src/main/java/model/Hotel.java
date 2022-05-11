package model;



import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Table(value="hoteles")
public class Hotel {
	@Id
	@Column(value = "idHotel")
	private int idhotel;
	private String nombre;
	private int categoria;
	private double precio;
	private int disponible;
	
}
