/* É necesário inserir todos os campos pro sistema funcionar */

create database projetojava default character set utf8;
use projetojava;

create table usuario(
	idUsuario int primary key auto_increment,
	usuario varchar(100) not null,
	senha varchar(100) not null
);

create table tipoaeronave (
	descricao varchar(100) 
);

create table aeronave(
	idTipoAeronave int primary key auto_increment,
	fabricante varchar(100) not null,
    modelo varchar(100) not null,
	codigoaeronave varchar(100) not null,
	tipoaeronave varchar(100) not null
);

INSERT INTO usuario (usuario, senha)
VALUES ('senai', '123');


/*Consultar e arrumar*/
select * from aeronave;


drop table aeronave;

drop database projetojava;