package br.edu.ifpb.usuarioservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application.jwt")
@Configuration
@Setter
@Getter
public class JwtConfig {
    private String secret;
    private Integer expirationTimeInSeconds;
}
