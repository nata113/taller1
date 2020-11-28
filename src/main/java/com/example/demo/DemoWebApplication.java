package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigServer
public class DemoWebApplication {

	@GetMapping("/")
	public String desplegado() {
		return "Se ha desplegado la app";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}

}
