drop table if exists reservation;
drop table if exists guest;
drop table if exists employee;
drop table if exists person;
drop table if exists room;
drop table if exists hotel;

create table if not exists person (
id int(6) auto_increment,
firstName varchar(15) not null,
lastName varchar(15) not null,
emailAdres varchar(30) not null,
passWord varchar(30) not null,
age int(2) not null,
primary key (id));

create table if not exists guest (
id int(6),
primary key (id),
foreign key (id) references person(id)
);

create table if not exists employee (
id int(6),
primary key (id),
foreign key (id) references person(id));

create table if not exists hotel (
hotelId int(6) auto_increment,
name varchar(30) not null,
primary key (hotelId));

create table if not exists room (
roomNumber int(6) auto_increment,
luxeRoom boolean not null default 0,
seaView boolean not null default 0,
hotelId int(6),
primary key (roomNumber),
foreign key (hotelId) references hotel(hotelId));


create table if not exists reservation (
reservationId int(6) auto_increment,
withBreakfast boolean not null default 0,
stayingLength int(2) not null,
guestId int(6),
roomNumber int(6),
primary key (reservationId),
foreign key (guestId) references guest(id),
foreign key (roomNumber) references room(roomNumber));
