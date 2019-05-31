package com.ifpb.pw.usuarioservice.repositories;

import com.ifpb.pw.usuarioservice.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
