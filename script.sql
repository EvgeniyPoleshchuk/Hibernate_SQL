create schema PERSONS
create table PERSONS
(
    id      serial,
    name    varchar NOT NULL ,
    surname varchar NOT NULL ,
    age int NOT NULL ,
    phone_number varchar NOT NULL ,
    city_of_living varchar NOT NULL,
    primary key (name,surname,age)
);
insert into PERSONS(name, surname, age, phone_number, city_of_living)
values ('Andrey','ivanov',25,'79213333333','Moscow');
insert into PERSONS(name, surname, age, phone_number, city_of_living)
values ('Serger','Smirnov',23,'79213333333','Spb');
insert into PERSONS(name, surname, age, phone_number, city_of_living)
values ('Анжелика','Варум',36,'79213333333','Moscow');
insert into PERSONS(name, surname, age, phone_number, city_of_living)
values ('Стас','Михаилов',37,'79213333333','Moscow');
insert into PERSONS(name, surname, age, phone_number, city_of_living)
values ('Mia','Khalifa',32,'79213333333','Miami');


