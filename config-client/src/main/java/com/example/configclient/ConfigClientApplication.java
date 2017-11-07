package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope // http://localhost:8080/refresh
@RestController
@SpringBootApplication
public class ConfigClientApplication {

	@Value("${user.role}")
	private String userRole;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@GetMapping("/userRole")
	public String getRole() {
		System.out.println("===== user role == "+userRole);
		return userRole;
	}
}
