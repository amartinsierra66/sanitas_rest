package com.sanitas.service;

import reactor.core.publisher.Mono;

public interface ClienteService {
	Mono<Boolean> procesarRespuesta();
}
