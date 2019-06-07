create sequence if not exists hibernate_sequence;

create table if not exists postagem
(
	id bigint not null
		constraint postagem_pkey
			primary key,
	postagem_data timestamp,
	publicacao_data timestamp,
	titulo varchar(255),
	nome varchar(255),
	corpo varchar(255),
	conteudos varchar(255),
	usuario varchar(255)
);

create table if not exists conteudo
(
	id bigint not null
		constraint conteudo_pkey
			primary key,
	cadastro timestamp,
	publicacao timestamp,
	descricao varchar(255),
	titulo varchar(255),
	status varchar(255),
	tipo varchar(255),
	midias varchar(255),
	usuario varchar(255)
);