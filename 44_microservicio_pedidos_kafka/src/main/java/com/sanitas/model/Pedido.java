package com.sanitas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter*/
@Data
public class Pedido {
	private String producto;
	private int unidades;
	private double precio;
	
}
