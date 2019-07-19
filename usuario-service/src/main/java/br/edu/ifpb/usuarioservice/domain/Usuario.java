package br.edu.ifpb.usuarioservice.domain;

import br.edu.ifpb.usuarioservice.domain.enumerated.TipoUsuario;
import br.edu.ifpb.usuarioservice.domain.enumerated.UsuarioStatus;
import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario extends AbstractAggregateRoot<Usuario> implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nome;

    @Column(unique = true)
    @NotNull
    @Email
    private String email;

    @NotNull
    private String senha;

    @Enumerated(value = EnumType.STRING)
    private UsuarioStatus status;
    private ZonedDateTime cadastroData;
    @Enumerated(value = EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(tipoUsuario.toString()).stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
