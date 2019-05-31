package com.ifpb.pw.usuarioservice;

import com.ifpb.pw.usuarioservice.domain.Usuario;
import com.ifpb.pw.usuarioservice.service.UsuarioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceApplicationTests {

	@Autowired
	private UsuarioService service;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createUser(){
		Usuario usuario = new Usuario();
		usuario.setNome("3 Teste");
		usuario.setEmail("email@teste.com");
		usuario.setSenha("12545");
		service.createOrUpdate(usuario);
	}

}
