package br.edu.ifpb.usuarioservice.controller;

import br.edu.ifpb.usuarioservice.data.LoginVM;
import br.edu.ifpb.usuarioservice.service.TokenProvider;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Autenticação")
@RestController
public class LoginController {

    private final TokenProvider tokenProvider;

    public LoginController(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginVM loginVM) {

        String token;
        try {
            token = tokenProvider.generateToken(loginVM.getLogin());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(token);

    }

}
