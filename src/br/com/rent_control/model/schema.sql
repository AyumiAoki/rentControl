use rent_control;

create table employee(
    name varchar(50) not null,
    cpf varchar(11) not null unique,
    nickname varchar(50) not null,
    password varchar(50) not null,
    primary key (cpf)
);

create table user(
    name varchar(50) not null,
    nationality varchar(35) not null,
    cpf varchar(11) not null unique,
    licenseNumber bigint not null unique,
    idNumber int not null unique,
    dateOfBirth varchar(8) not null,
    cep int not null,
    numberHouse int,
    neighborhood varchar(60) not null,
    road varchar(60) not null,
    city varchar(60) not null,
    state varchar(50) not null,
    primary key (cpf)
);

create table car(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category varchar(9) not null,
    maxPassengers int not null,
    trunkSize double not null,
    transmissionType varchar(10) not null,
    fuelType varchar(8) not null,
    hasAc boolean not null,
    hasAirbag boolean not null,
    hasAbsBrakes boolean not null,
    hasDvdPlayer boolean not null,
    dailyCost double not null
);

create table rent(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    withdrawalDate varchar(8) not null,
    pickUpLocation varchar(50) not null,
    deliveryDate varchar(8) not null,
    deliveryLocation varchar(50) not null,
    carProtection boolean not null,
    gps boolean not null,
    cleaning boolean not null,
    drinkComfort boolean not null,
    babyChair boolean not null,
    boosterSeat boolean not null,
    cpfUser varchar(11) not null unique,
    idCar INT NOT NULL,
    foreign key (cpfUser) references user(cpf),
    foreign key (idCar) references car(id)
);
