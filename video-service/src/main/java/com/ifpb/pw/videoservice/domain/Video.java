package com.ifpb.pw.videoservice.domain;

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
public class Video extends AbstractAggregateRoot<Video> {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String tamanho;
    private String duracao;
    private ZonedDateTime cadastro_data;
    private String usuario;

}