package com.ifpb.pw.redesocialservice.service;

import com.ifpb.pw.redesocialservice.domain.Conteudo;
import com.ifpb.pw.redesocialservice.repositories.ConteudoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ConteudoService {

	private final ConteudoRepository conteudoRepository;

	public ConteudoService(ConteudoRepository conteudoRepository) {
		this.conteudoRepository = conteudoRepository;
	}

	public void criarConteudoComPublicacaoManual(Conteudo conteudo) {
		conteudoRepository.save(conteudo);
	}

	public Conteudo criarConteudo(Conteudo conteudo) {
		return conteudoRepository.save(conteudo);
	}

	public void removerConteudo(Long conteudoId) {
		conteudoRepository.deleteById(conteudoId);
	}

	public List<Conteudo> listarConteudos() {
		return conteudoRepository.findAll();
	}

	public Optional<Conteudo> recuperarPorId(Long id) {
		return conteudoRepository.findById(id);
	}

}
