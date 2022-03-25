/*Table Station*/
INSERT INTO Station (idStation,adresse,statu)
	VALUES
	(1,'1 rue alpha','vplus'),
	(2,'2 rue beta','vnul'),
	(3,'3 rue gamma','vnul'),
	(4,'4 rue delta','vnul'),
	(5,'5 rue epsilon','vmoins');

/*Table Bornette*/
INSERT INTO Bornette (idBornette,idStation,etatBornette)
	VALUES
	(101,1,'ok'),
	(102,1,'ok'),
	(103,1,'ok'),
	(104,1,'ok'),
	(105,1,'ok'),
	(106,1,'ok'),
	(107,1,'ok'),
	(108,1,'hs'),
	(109,1,'ok'),
	(110,1,'ok'),
	(201,2,'ok'),
	(202,2,'ok'),
	(203,2,'ok'),
	(204,2,'ok'),
	(205,2,'ok'),
	(206,2,'ok'),
	(207,2,'ok'),
	(208,2,'hs'),
	(209,2,'ok'),
	(210,2,'ok'),
	(301,3,'ok'),
	(302,3,'ok'),
	(303,3,'ok'),
	(304,3,'ok'),
	(305,3,'ok'),
	(306,3,'ok'),
	(307,3,'ok'),
	(308,3,'hs'),
	(309,3,'ok'),
	(310,3,'ok'),
	(401,4,'ok'),
	(402,4,'ok'),
	(403,4,'ok'),
	(404,4,'ok'),
	(405,4,'ok'),
	(406,4,'ok'),
	(407,4,'ok'),
	(408,4,'hs'),
	(409,4,'ok'),
	(410,4,'ok'),
	(501,5,'ok'),
	(502,5,'ok'),
	(503,5,'ok'),
	(504,5,'ok'),
	(505,5,'ok'),
	(506,5,'ok'),
	(507,5,'ok'),
	(508,5,'hs'),
	(509,5,'ok'),
	(510,5,'ok');

/*Table Velo*/
INSERT INTO Velo (idVelo,idBornette,modelVelo,etatVelo,dateMenS)
	VALUES
	(1,101,'manuel','ok','22-01-02'),
	(2,102,'manuel','ok','22-01-03'),
	(3,103,'electrique','ok','22-01-04'),
	(4,null,'electrique','hs','22-01-05'),
	(5,105,'manuel','ok','22-01-01'),
	(6,201,'manuel','ok','22-01-02'),
	(7,202,'manuel','ok','22-01-03'),
	(8,null,'electrique','hs','22-01-04'),
	(9,204,'electrique','ok','22-01-05'),
	(10,205,'manuel','ok','22-01-01'),
	(11,301,'manuel','ok','22-01-02'),
	(12,null,'manuel','hs','22-01-03'),
	(13,303,'electrique','ok','22-01-04'),
	(14,304,'electrique','ok','22-01-05'),
	(15,305,'manuel','ok','22-01-01'),
	(16,null,'manuel','hs','22-01-02'),
	(17,402,'manuel','ok','22-01-03'),
	(18,403,'electrique','ok','22-01-04'),
	(19,404,'electrique','ok','22-01-05'),
	(20,null,'manuel','hs','22-01-01'),
	(21,501,'manuel','ok','22-01-02'),
	(22,502,'manuel','ok','22-01-03'),
	(23,503,'electrique','ok','22-01-04'),
	(24,null,'electrique','hs','22-01-05'),
	(25,505,'manuel','ok','22-01-01');

/*Table Client*/
INSERT INTO Client (idClient,numCB)
	VALUES
	(1,"5355505140410001"),-- MARTIN
	(2,"5355505140410003"),-- DUPONT - Jade
	(3,"5355505140410002"),-- PEREZ
	(4,"5355505140410003"),-- DUPONT - Louise
	(5,"5355505140410005"),
	(6,"5355505140410006"),
	(7,"5355505140410007"),
	(8,"5355505140410008"),
	(9,"5355505140410009"),
	(10,"5355505140410010");

/*Table Abonne*/
INSERT INTO Abonne (idAbonne,idClient,nom,prenom,dateNaissance,sexe,dateAbonnement,codeSecret)
	VALUES
	(1,1,"MARTIN","Léo","1992-04-28","h","2022-03-08","4496"),
	(2,2,"DUPONT","Jade","1995-02-17","f","2022-02-18","3814"),
	(3,3,"PEREZ","Gabriel","1983-09-19","h","2022-02-12","4415"),
	(4,4,"DUPONT","Louise","2000-01-12","f","2022-03-11","3811");

/*Table Location
-- INSERT INTO Location (idLocation,idClient,prix,codeSecret)
	--VALUES
	--(1,1,0,null),/*Location Abonne 1 velo en cours
    --(2,2,0,null),/*Location Abonne 1 velo fini
    --(3,3,0,null),/*Location Abonne +1 velo en cours
    --(4,4,0,null),/*Location Abonne +1 velo fini
    --(5,5,0,null),/*Location Non-Abonne 1 velo en cours
    --(6,6,0,null),/*Location Non-Abonne 1 velo fini
    --(7,7,0,null),/*Location Non-Abonne +1 velo en cours
    --(8,8,0,null);/*Location Non-Abonne +1 velo fin

--Table LocationDetail
--INSERT INTO Location (idLocationDetail,idLocation,idVelo,prix,depart,arrivee,debut,fin)
	--VALUES
    --Location 1 Abonne 1 velo en cours
    
    --Location 2 Abonne 1 velo fini

    --Location 3 Abonne +1 velo en cours

    --Location 4 Abonne +1 velo fini

    --Location 5 Non-Abonne 1 velo en cours

    --Location 6 Non-Abonne 1 velo fini

    --Location 7 Non-Abonne +1 velo en cours

    --Location 8 Non-Abonne +1 velo fini
*/


