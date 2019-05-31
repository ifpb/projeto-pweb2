package com.ifpb.pw.usuarioservice.controller;

import com.ifpb.pw.usuarioservice.domain.Usuario;
import com.ifpb.pw.usuarioservice.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Gerenciamento de Usuários da Aplicação")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarios")
    @ApiOperation(value = "Listagem de usuários")
    public List<Usuario> listar(){
        return service.findAll();
    }

    @GetMapping("/usuarios/{id}")
    @ApiOperation(value = "Busca de usuários por id")
    public ResponseEntity<Usuario> buscar(@PathVariable("id") @ApiParam("Identificação única do usuário") Long id){
        Usuario usuario = service.findById(id);
        if (usuario != null){
            return ResponseEntity.ok().body(usuario);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/usuarios")
    @ApiOperation(value = "Criação de usuários")
    public Usuario criar(@RequestBody Usuario usuario){
        return service.createOrUpdate(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    @ApiOperation(value = "Remoção de usuários")
    public void deletar(@PathVariable("id") @ApiParam("Identificação única do usuário") Long id){
        service.delete(id);
    }

    @PutMapping("/usuarios/{id}")
    @ApiOperation(value = "Atualização de usuários")
    public Usuario atualizar(@PathVariable("id") @ApiParam("Identificação única do usuário") Long id, @RequestBody Usuario usuario){
        return service.createOrUpdate(usuario);
    }
}
