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



