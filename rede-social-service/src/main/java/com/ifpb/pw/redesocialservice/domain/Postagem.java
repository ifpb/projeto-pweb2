package com.ifpb.pw.redesocialservice.domain;

import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Postagem extends AbstractAggregateRoot<Postagem> {

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String corpo;
    private ZonedDateTime postagem_data;
    private ZonedDateTime publicacao_data;
//    private List<String> conteudos;
    private String conteudos;
    private String usuario;

}