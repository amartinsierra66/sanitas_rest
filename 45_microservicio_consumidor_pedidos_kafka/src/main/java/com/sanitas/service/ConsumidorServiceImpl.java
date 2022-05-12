package com.sanitas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sanitas.model.Pedido;
@Service
public class ConsumidorServiceImpl implements ConsumidorService {
	/*@Value("${topic}")
	String topic;*/
	private List<Pedido> ventas=new ArrayList<Pedido>();
	@Override
	public List<Pedido> recuperarVentas() {
		return ventas;
	}
	@KafkaListener(topics = "pedidos", groupId = "myGroup")
	public void consumer(Pedido venta) {
		System.out.println("pedido recibido: "+venta);
		ventas.add(venta);
	}

}
