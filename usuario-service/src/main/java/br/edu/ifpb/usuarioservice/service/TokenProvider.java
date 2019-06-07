package br.edu.ifpb.usuarioservice.service;

import br.edu.ifpb.usuarioservice.config.JWTConfig;
import br.edu.ifpb.usuarioservice.domain.Usuario;
import br.edu.ifpb.usuarioservice.repositories.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.ZonedDateTime;

@Service
public class TokenProvider {

    private final UsuarioRepository usuarioRepository;

    private final JWTConfig jwtConfig;

    private static String TIPO_KEY = "TIPO";

    public TokenProvider(UsuarioRepository usuarioRepository, JWTConfig jwtConfig) {
        this.usuarioRepository = usuarioRepository;
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(String email) throws Exception {

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow( () -> new Exception("Usuário não existe"));

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime expiration = now.plusSeconds(jwtConfig.getJwt().getExpirationTimeInSeconds());

        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim(TIPO_KEY, usuario.getTipo_usuario())
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getJwt().getSecret())
                .setExpiration(Date.from(expiration.toInstant()))
                .compact();
    }

}
