drop table if exists LocationsDetail;
drop table if exists Locations;
drop table if exists Abonne;
drop table if exists Client;
drop table if exists Velo;
drop table if exists Bornette;
drop table if exists Station;

create table Station (
    idStation int primary key,
	adresse varchar(30),
	statu varchar(20),
	constraint ck1_S check (statu in ('vplus','vnul','vmoins'))
);

create table Bornette (
	idBornette int primary key,
	idStation int,
	etatBornette varchar(20),
    constraint fk_B foreign KEY (idStation) references Station (idStation),
	constraint ck1_B check (etatBornette in ('ok','hs'))
);

create table Velo (
	idVelo int primary key,
	idBornette int,
	modelVelo varchar(20),
	etatVelo varchar(20),
	dateMenS date,
	constraint fk_V foreign KEY (idBornette) references Bornette (idBornette),
	constraint ck1_V check (modelVelo in ('manuel','electrique')),
	constraint ck2_V check (etatVelo in ('ok','hs','maintenance'))
);

create table Client(
	idClient int primary key,
	numCB varchar(16)
);

create table Abonne(
	idAbonne int primary key,
	idClient int,
	nom varchar(20),
	prenom varchar(20),
	dateNaissance datetime,
	sexe varchar(10),
	dateAbonnement datetime,
	codeSecret int,
	constraint ck1_A check (sexe in ('h','f')),
	constraint fk_A foreign KEY (idClient) references Client (idClient)
);

create table Locations(
	idLocations int primary key,
	idClient int,
	prix float,	
	codeSecret integer,
	constraint fk_L foreign KEY (idClient) references Client (idClient)
);

create table LocationsDetail(
	idLocationsDetail int primary key,
	idVelo int,
	debut datetime,
	fin datetime,
	depart int,
	arrivee int,
	prix float,	
	codeSecret integer,
	constraint fk_LD foreign KEY (idVelo) references Velo (idVelo),
	constraint fk_LD2 foreign KEY (depart) references Station (idStation),
	constraint fk_LD3 foreign KEY (arrivee) references Station (idStation)
);


