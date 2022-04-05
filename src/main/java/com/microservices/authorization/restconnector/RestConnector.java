package com.microservices.authorization.restconnector;

import com.microservices.authorization.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "Feign", url = "http://localhost:8020")
public interface RestConnector {

    @GetMapping("v1/persons/{id}")
    PersonDto getPerson(@PathVariable String id);
}
