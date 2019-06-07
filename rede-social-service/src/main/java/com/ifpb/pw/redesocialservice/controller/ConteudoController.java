package com.ifpb.pw.redesocialservice.controller;

import com.ifpb.pw.redesocialservice.domain.Conteudo;
import com.ifpb.pw.redesocialservice.service.ConteudoService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Gerenciamento de Postagem da Aplicação")
public class ConteudoController {

    private final ConteudoService conteudoService;

    public ConteudoController(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }

    @GetMapping("/conteudos/{id}")
    public ResponseEntity<Conteudo> recuperarConteudo(@PathVariable("id") Long id) {
        Optional<Conteudo> conteudoOptional = this.conteudoService.recuperarPorId(id);
        if (conteudoOptional.isPresent()) {
            return ResponseEntity.ok().body(conteudoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/conteudos")
    public List<Conteudo> listarConteudos() {
        return conteudoService.listarConteudos();
    }

    @PostMapping("/conteudos")
    public Conteudo criarConteudo(@RequestBody Conteudo conteudo) {
        return conteudoService.criarConteudo(conteudo);
    }

    @DeleteMapping("/conteudos/{id}")
    public void removerConteudo(@PathVariable("id") Long id) {
        conteudoService.removerConteudo(id);
    }
}
