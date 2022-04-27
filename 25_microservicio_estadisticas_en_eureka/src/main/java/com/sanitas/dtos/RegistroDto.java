package com.sanitas.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistroDto {
	private String ip;
	private int tiempo;
	private Date fecha;
	private boolean multiple;
}
