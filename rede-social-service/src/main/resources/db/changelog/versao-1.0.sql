create sequence if not exists hibernate_sequence;

create table if not exists video
(
	id bigint not null
		constraint video_pkey
			primary key,
	cadastro_data timestamp,
	nome varchar(255),
	tamanho varchar(255),
	duracao varchar(255),
	usuario varchar(255)
);
