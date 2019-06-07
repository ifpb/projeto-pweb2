package com.ifpb.pw.redesocialservice.domain;

import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Conteudo extends AbstractAggregateRoot<Conteudo> {

    public enum ConteudoStatus { PENDENTE, PUBLICADO }

    public enum ConteudoTipo { AUDIO, VIDEO, IMAGEM, DOCUMENTO }

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private ZonedDateTime cadastro;
    private String descricao;
    private ZonedDateTime publicacao;
    private ConteudoStatus status;
    private ConteudoTipo tipo;
    private String usuario;

//    @OneToMany(mappedBy = "conteudo")
//    private List<Midias> midias;
    private String midias;
}