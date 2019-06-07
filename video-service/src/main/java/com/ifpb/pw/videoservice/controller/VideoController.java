package com.ifpb.pw.videoservice.controller;

import com.ifpb.pw.videoservice.domain.Video;
import com.ifpb.pw.videoservice.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Gerenciamento de Videos da Aplicação")
public class VideoController {

    private final VideoService service;

    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping("/videos")
    @ApiOperation(value = "Listagem de videos")
    public List<Video> listar(){
        return service.findAll();
    }

    @GetMapping("/videos/{id}")
    @ApiOperation(value = "Busca de videos por id")
    public ResponseEntity<Video> buscar(@PathVariable("id") @ApiParam("Identificação única do video") Long id){
        Video video = service.findById(id);
        if (video != null){
            return ResponseEntity.ok().body(video);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/videos")
    @ApiOperation(value = "Criação de video")
    public Video criar(@RequestBody Video video){
        return service.createOrUpdate(video);
    }

    @DeleteMapping("/videos/{id}")
    @ApiOperation(value = "Remoção de videos")
    public void deletar(@PathVariable("id") @ApiParam("Identificação única do video") Long id){
        service.delete(id);
    }

    @PutMapping("/videos/{id}")
    @ApiOperation(value = "Atualização de videos")
    public Video atualizar(@PathVariable("id") @ApiParam("Identificação única do video") Long id, @RequestBody Video video){
        return service.createOrUpdate(video);
    }
}
