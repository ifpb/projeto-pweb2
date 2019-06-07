package com.ifpb.pw.redesocialservice.service;

import com.ifpb.pw.redesocialservice.domain.Postagem;
import com.ifpb.pw.redesocialservice.repositories.PostagemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostagemService {

    private final PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public List<Postagem> findAll(){
        return postagemRepository.findAll();
    }

    public Postagem findById(Long id){
        return postagemRepository.findById(id).get();
    }

    public Postagem createOrUpdate(Postagem postagem){
        return postagemRepository.save(postagem);
    }

    public void delete(Long id){
        postagemRepository.deleteById(id);
    }

}
