package com.ifpb.pw.usuarioservice.domain;

import com.ifpb.pw.usuarioservice.domain.enumerated.TipoUsuario;
import com.ifpb.pw.usuarioservice.domain.enumerated.UsuarioStatus;
import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario extends AbstractAggregateRoot<Usuario> {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @Enumerated(value = EnumType.STRING)
    private UsuarioStatus status;
    private ZonedDateTime cadastro_data;
    @Enumerated(value = EnumType.STRING)
    private TipoUsuario tipo_usuario;
}
