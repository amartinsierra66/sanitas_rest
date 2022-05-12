package com.sanitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.sanitas.model.Pedido;
@Service(value = "service1")
public class PedidosServiceImpl implements PedidosService {
	@Autowired
	private KafkaTemplate<String, Pedido> kafkaTemplate;
	@Value("${topic}")
	String topic;
	@Override
	public void publicarPedido(Pedido pedido) {
		ListenableFuture<SendResult<String, Pedido>> future = kafkaTemplate.send(topic, pedido);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Pedido>>() {
			@Override
			public void onSuccess(SendResult<String, Pedido> result) {
				System.out.println("Enviado "+result.getProducerRecord().value().getProducto()+" al topic "+result.getRecordMetadata().topic());
			}
			@Override
			public void onFailure(Throwable ex) {
				ex.printStackTrace();
			}
		});

	}

}
