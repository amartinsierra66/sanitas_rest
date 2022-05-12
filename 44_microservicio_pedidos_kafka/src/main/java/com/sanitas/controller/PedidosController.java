package com.sanitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.model.Pedido;
import com.sanitas.service.PedidosService;

@RestController
public class PedidosController {
	@Autowired
	@Qualifier(value = "service1")
	PedidosService service;
	@PostMapping(value="pedido",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void pedido(@RequestBody Pedido pedido) {		
		service.publicarPedido(pedido);
	}
}
