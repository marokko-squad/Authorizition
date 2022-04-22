package com.microservices.authorization;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("spring-auth-server-mock")
public class UrlConfig {
    public String url;
}
