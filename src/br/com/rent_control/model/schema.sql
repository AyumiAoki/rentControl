use rent_control;

create table employee(
    name varchar(50) not null,
    cpf varchar(11) not null unique,
    nickname varchar(50) not null,
    password varchar(50) not null,
    primary key (cpf)
);

create table customer(
    name varchar(50) not null,
    cpf varchar(11) not null unique,
    licenseNumber bigint not null unique,
    dateOfBirth varchar(8) not null,
    primary key (cpf)
);

create table car(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category varchar(9) not null,
    model varchar(30) not null,
    maxPassengers int not null,
    trunkSize double not null,
    transmissionType varchar(10) not null,
    fuelType varchar(8) not null,
    consumptionAverage double not null,
    dailyCost double not null,
    hasAc boolean not null,
    hasAirbag boolean not null,
    hasAbsBrakes boolean not null,
    hasDvdPlayer boolean not null
);

create table rent(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    withdrawalDate varchar(8) not null,
    withdrawalTime varchar(4) not null,
    deliveryDate varchar(8) not null,
    deliveryTime varchar(4) not null,
    carProtection boolean not null,
    gps boolean not null,
    cleaning boolean not null,
    drinkComfort boolean not null,
    babyChair boolean not null,
    boosterSeat boolean not null,
    cpfCustomer varchar(11) not null,
    idCar int not null,
    foreign key (cpfCustomer) references customer(cpf),
    foreign key (idCar) references car(id)
);

insert into employee values ("Ayumi Aoki", "04761241233", "ayumi", "123");
