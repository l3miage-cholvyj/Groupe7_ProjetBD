drop table if exists Station;
drop table if exists Bornette;
drop table if exists Velo;
drop table if exists Locations;
drop table if exists Trajet;
drop table if exists Client;
drop table if exists Abonne;

--- la création des tables 

create table Station (
    idStation int primary key,
	adresse varchar(30),
	statu varchar(20),
	constraint ck1_S check (statu in ('vplus','vnul','vmoins'))
);


----------
create table Bornette (
	idBorne int primary key,
	idStation int,
	etatBornette varchar(20),
    constraint fk_B foreign KEY (idStation) references Station (idStation),
	constraint ck1_B check (etatBornette in ('ok','hs'))
);
----------
create table Velo (
	idVelo int primary key,
	idBorne int,
	modelVelo varchar(20),
	etatVelo varchar(20),
	dateMenS date,
	constraint fk_V foreign KEY (idBorne) references Bornette (idBorne),
	constraint ck1_V check (modelVelo in ('manuel','electrique')),
	constraint ck2_V check (etatVelo in ('ok','hs','maintenance'))
);

---------- n'est pas fait d'abord 
create table Locations(
	numCB integer,
	prix float,
	debut date,
	fin date,
	codeSecret integer
);

--------------------------
create table Trajet(
	idVelo int ,
	StationDepart varchar(20),
	StationArrevee varchar(20)
);

--------------------------
create table Client(
	numCB integer
);
create table Abonne(
	numCB integer,
	nom varchar(20),
	prenoms varchar(20),
	dateNaissance date,
	sexe varchar(10),
	dateAbonnement date,
	codeSecret integer,
	constraint ck1_A check (sexe in ('masculin','feminin'))
);

