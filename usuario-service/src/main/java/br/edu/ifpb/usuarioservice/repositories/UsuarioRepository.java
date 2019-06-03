package br.edu.ifpb.usuarioservice.repositories;

import br.edu.ifpb.usuarioservice.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
