package com.ifpb.pw.redesocialservice.controller;

import com.ifpb.pw.redesocialservice.domain.Postagem;
import com.ifpb.pw.redesocialservice.service.PostagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Gerenciamento de Postagem da Aplicação")
public class PostagemController {

    private final PostagemService service;

    public PostagemController(PostagemService service) {
        this.service = service;
    }

    @GetMapping("/postagens")
    @ApiOperation(value = "Listagem de postagens")
    public List<Postagem> listar(){
        return service.findAll();
    }

    @GetMapping("/postagem/{id}")
    @ApiOperation(value = "Busca de postagem por id")
    public ResponseEntity<Postagem> buscar(@PathVariable("id") @ApiParam("Identificação única da postagem") Long id){
        Postagem postagem = service.findById(id);
        if (postagem != null){
            return ResponseEntity.ok().body(postagem);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/postagens")
    @ApiOperation(value = "Criação da postagem")
    public Postagem criar(@RequestBody Postagem postagem){
        return service.createOrUpdate(postagem);
    }

    @DeleteMapping("/postagens/{id}")
    @ApiOperation(value = "Remoção de postagens")
    public void deletar(@PathVariable("id") @ApiParam("Identificação única da postagem") Long id){
        service.delete(id);
    }

    @PutMapping("/postagens/{id}")
    @ApiOperation(value = "Atualização da postagem")
    public Postagem atualizar(@PathVariable("id") @ApiParam("Identificação única da postagem") Long id,
                              @RequestBody Postagem postagem){

        return service.createOrUpdate(postagem);
    }
}
