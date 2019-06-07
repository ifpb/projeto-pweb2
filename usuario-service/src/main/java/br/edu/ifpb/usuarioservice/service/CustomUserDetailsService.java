package br.edu.ifpb.usuarioservice.service;

import br.edu.ifpb.usuarioservice.domain.Usuario;
import br.edu.ifpb.usuarioservice.repositories.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repository;

    public CustomUserDetailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = Optional.ofNullable(repository.findByEmail(email))
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authorityBanda =  AuthorityUtils.createAuthorityList("ROLE_BANDA");

        return  new User(
                usuario.getEmail(),
                usuario.getSenha(),
                authorityBanda
        );
    }
}
