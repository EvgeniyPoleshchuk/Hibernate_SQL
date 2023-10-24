create table Persons
(
    id      serial,
    name    varchar NOT NULL ,
    surname varchar NOT NULL ,
    age int NOT NULL ,
    phone_number varchar NOT NULL ,
    city_of_living varchar NOT NULL,
    primary key (name,surname,age)
);
insert into Persons(name, surname, age, phone_number, city_of_living)
VALUES ('Petya','LOX',33,'213213123','Moscow')

