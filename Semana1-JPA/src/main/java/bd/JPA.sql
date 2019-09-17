create schema hibernate;
use hibernate;


create table productos(
id int(11) auto_increment primary key not null,
nombre varchar(225) null,
precio decimal(6,2) null
);