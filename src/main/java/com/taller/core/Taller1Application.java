package com.taller.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
@EnableConfigServer
@EnableDiscoveryClient
public class Taller1Application implements WebMvcConfigurer {

	@GetMapping("/")
	public String desplegado() {
		return "Se ha desplegado la app";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Taller1Application.class, args);
	}

}
