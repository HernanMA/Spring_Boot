create database restaurant_management;
use restaurant_management;

create table platillos(
	id int primary key auto_increment,
    name varchar(50),
    price double(10,2),
    enable boolean
);

create table mesas(
	id int primary key auto_increment,
    table_number int,
    busy boolean
);
