create database Autos;
use Autos;

create table Automovil(
id int primary key auto_increment,
marca varchar(15),
llantas int(12),
color varchar(15),
tipo varchar(20)
);