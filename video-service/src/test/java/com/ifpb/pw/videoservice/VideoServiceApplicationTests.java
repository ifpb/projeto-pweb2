package com.ifpb.pw.videoservice;

import com.ifpb.pw.videoservice.domain.Video;
import com.ifpb.pw.videoservice.service.VideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoServiceApplicationTests {

	@Autowired
	private VideoService service;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createVideo(){
		Video video = new Video();
		video.setNome("3 Teste");
		video.setTamanho("500kb");
		service.createOrUpdate(video);
	}

}
