package br.edu.ifpb.usuarioservice.service;

import br.edu.ifpb.usuarioservice.repositories.UsuarioRepository;
import br.edu.ifpb.usuarioservice.domain.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).get();
    }

    public Usuario createOrUpdate(Usuario usuario){
        Usuario novoUsuario = usuarioRepository.findByEmail(usuario.getEmail()).orElse(new Usuario());
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setTipoUsuario(usuario.getTipoUsuario());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    public boolean isValid(Usuario usuario){
        boolean isValid = true;

        if(validarSenha(usuario.getSenha())){
            isValid = false;
            log.info("USUARIO VALIDO");
        }

        return isValid;
    }


    private boolean validarSenha(String senha){
        boolean isValid = true;

        if(senha.trim().length() <= 4){
            isValid = false;
        }

        return isValid;
    }

}
