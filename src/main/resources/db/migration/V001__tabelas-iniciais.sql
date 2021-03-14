create table usuario (
    id integer,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(100) not null,

    constraint usuario_pk primary key (id),
    constraint usuario_email_unique unique (email)
);

create table produto (
    id integer,
    nome varchar(255) not null,
    descricao varchar(2000),
    preco decimal(10, 2) not null,

    constraint produto_pk primary key (id)
);

create sequence usuario_sequence;
create sequence produto_sequence;