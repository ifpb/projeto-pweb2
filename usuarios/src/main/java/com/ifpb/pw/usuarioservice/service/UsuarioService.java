package com.ifpb.pw.usuarioservice.service;

import com.ifpb.pw.usuarioservice.domain.Usuario;
import com.ifpb.pw.usuarioservice.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).get();
    }

    public Usuario createOrUpdate(Usuario usuario){
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
