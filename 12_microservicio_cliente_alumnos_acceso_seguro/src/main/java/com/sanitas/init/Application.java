package com.sanitas.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.sanitas.controller","com.sanitas.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		//interceptor de seguridad
		BasicAuthenticationInterceptor intercep=new BasicAuthenticationInterceptor("admin", "admin");	
		RestTemplate template= new RestTemplate();
		//asociamos interceptor
		template.getInterceptors().add(intercep);
		return template;
		//return new RestTemplate();
	}

}
