package com.ifpb.pw.redesocialservice.repositories;

import com.ifpb.pw.redesocialservice.domain.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
