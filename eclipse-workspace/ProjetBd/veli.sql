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
	idVelo int,
	idBorne int,
	modelVelo varchar(20),
	etatVelo varchar(20),
	dateMenS date,
	constraint fk_V foreign KEY (idBorne) references Bornette (idBorne),
	constraint ck1_V check (modelVelo in ('manuel','electrique')),
	constraint ck2_V check (etatVelo in ('ok','hs','maintenance'))
);