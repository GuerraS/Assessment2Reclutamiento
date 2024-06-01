create database if not exists clothes_ecommerce;

create table categories (
  id int primary key auto_increment,
  name char(50) not null,
  description text
);

create table suppliers(
  id int primary key auto_increment,
  name char(100) not null
);

create table product_inventory(
  id int primary key auto_increment,
  quantity int not null default 0
);


