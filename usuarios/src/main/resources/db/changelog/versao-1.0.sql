create sequence hibernate_sequence;

create table if not exists usuario
(
	id bigint not null
		constraint usuario_pkey
			primary key,
	cadastro_data timestamp,
	email varchar(255),
	nome varchar(255),
	senha varchar(255),
	status varchar(255),
	tipo_usuario varchar(255)
);
