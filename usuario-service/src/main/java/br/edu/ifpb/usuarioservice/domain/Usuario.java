package br.edu.ifpb.usuarioservice.domain;

import br.edu.ifpb.usuarioservice.domain.enumerated.TipoUsuario;
import br.edu.ifpb.usuarioservice.domain.enumerated.UsuarioStatus;
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
    private ZonedDateTime cadastroData;
    @Enumerated(value = EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
