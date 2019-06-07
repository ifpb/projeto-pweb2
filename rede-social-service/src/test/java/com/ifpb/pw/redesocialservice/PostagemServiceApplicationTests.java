package com.ifpb.pw.redesocialservice;

import com.ifpb.pw.redesocialservice.service.PostagemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostagemServiceApplicationTests {

	@Autowired
	private PostagemService service;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createVideo(){
//		Postagem postagem = new Postagem();
		//set infos
//		service.createOrUpdate(postagem);
	}

}
