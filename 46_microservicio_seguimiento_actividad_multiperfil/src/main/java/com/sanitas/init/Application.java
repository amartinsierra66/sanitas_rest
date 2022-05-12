package com.sanitas.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.sanitas.service",
		"com.sanitas.controller",
		"com.sanitas.init",
		"com.sanitas.converters"})
@EnableJpaRepositories(basePackages = {"com.sanitas.dao"})
@EnableTransactionManagement
@EntityScan(basePackages = {"com.sanitas.model"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
