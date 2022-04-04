package com.microservices.authorization;

import com.microservices.authorization.dto.PersonDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class AuthorizationApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

	@GetMapping("/auth/v1/is-allowed")
	public ResponseEntity<String> isAllowed(){
		PersonDto person = new RestTemplate().getForObject("http://localhost:8020/v1/persons/3", PersonDto.class);
		return new ResponseEntity<>(person.getName(), HttpStatus.OK);
	}
}


