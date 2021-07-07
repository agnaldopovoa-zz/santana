create schema if not exists users;

create table users.user (
    id bigserial primary key,
    name varchar(50) not null,
    cpf varchar(18) not null,
    address varchar(100),
    email varchar(50),
    telephone varchar(20) ,
    register_date timestamp not null
);