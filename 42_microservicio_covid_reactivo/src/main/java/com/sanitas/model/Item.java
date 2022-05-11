package com.sanitas.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
	@JsonAlias("country")
	private String pais;
	@JsonAlias("indicator")
	private String indicador;
	@JsonAlias("year_week")
	private String semana;
	@JsonAlias("cumulative_count")
	private int acumulativo;
	@JsonAlias("rate_14_day")
	private double ratio;
}
