create database if not exists gimnasio;
use gimnasio;

create table clientes (
	dni varchar (9) primary key,
    nombre varchar (35) not null,
    apellidos varchar (35) not null,
    fechaNacimiento date not null,
    fechaAlta date not null
);