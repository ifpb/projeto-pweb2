package br.edu.ifpb.usuarioservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application")
@Configuration
@Setter
@Getter
public class JWTConfig {

    private JWT jwt;

    @Setter
    @Getter
    public static class JWT {
        private String secret;
        private Integer expirationTimeInSeconds;
    }
}
