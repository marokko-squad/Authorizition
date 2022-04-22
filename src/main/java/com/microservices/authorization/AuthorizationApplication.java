package com.microservices.authorization;

import com.microservices.authorization.dto.PersonDto;
import com.microservices.authorization.restconnector.RestConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class AuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

	@Autowired
	RestConnector restConnector;

	@Autowired
	UrlConfig urlConfig;

	@GetMapping("/auth/v1/is-allowed")
	public ResponseEntity<String> isAllowed(){
		System.out.println("urlConfig.getUrl() = " + urlConfig.getUrl());
		PersonDto person = restConnector.getPerson("3");
		return new ResponseEntity<>(person.getName(), HttpStatus.OK);
	}

}


