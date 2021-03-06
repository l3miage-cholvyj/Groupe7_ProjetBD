/*Station*/
SELECT * FROM Station;
/*Bornette*/
SELECT * FROM Bornette;
/*Velo*/
SELECT * FROM Velo;
/*Client*/
SELECT * FROM Client;
/*Abonne*/
SELECT * FROM Abonne;
/*Locations*/
SELECT * FROM Locations;
/*LocationDetail*/
SELECT * FROM LocationsDetail;

/*Affiche les abonnés avec leur CB*/
SELECT * FROM Abonne NATURAL JOIN Client;

/*Retourne l'abonnee selon son nom et son code Secret*/
SELECT * FROM Abonne NATURAL JOIN Client WHERE (nom = "MARTIN" and codeSecret = 4496); 

/*Retourne la Station selon son id*/
SELECT * FROM Station WHERE (id = 1);

/*Retourne les Stations vplus*/
SELECT * FROM Station WHERE (statu = 'vplus');

/*Retourne les Stations moins*/
SELECT * FROM Station WHERE (statu = 'vmoins');

/*Retourne le premier velo disponible de model manuel de la sation N° X*/
SELECT * FROM Velo LEFT JOIN Bornette USING (idBornette) WHERE (idStation = 1 and modelVelo = "manuel") LIMIT 1;

/*Retourne le premier velo disponible de model manuel de la sation N° X*/
SELECT * FROM Velo LEFT JOIN Bornette USING (idBornette) WHERE (idStation = 1 and modelVelo = "electrique") LIMIT 1;

/*Retourne la première bornette libre en état de marche de la station X*/
SELECT * FROM Velo RIGHT JOIN Bornette USING (idBornette) WHERE (idStation = 1 and etatBornette = 'ok' and idVelo is  NULL) LIMIT 1;

/*Retourne tous les vélos d'une locations X*/
SELECT * FROM LocationsDetail WHERE (idLocations = 2);

/*Retourne tous le premiers vélos d'une locations X*/
SELECT * FROM LocationsDetail WHERE (idLocations = 2) LIMIT 1;

/*Retourne le nombre de vélos d'une locations X*/
SELECT COUNT(*) FROM LocationsDetail WHERE (idLocations = 2);

/*Retourne tous les locations d'un locations X*/
SELECT * FROM Locations NATURAL JOIN Client LEFT JOIN Abonne USING (idClient) WHERE (idAbonne = 1);

/*Retourne tous le nombre de locations d'un locations X*/
SELECT COUNT(*) AS nbLocations  FROM Locations NATURAL JOIN Client LEFT JOIN Abonne USING (idClient) WHERE (idAbonne = 1);

/*Crée un abonne*/
INSERT INTO Abonne (idClient,nom,prenom,dateNaissance,sexe,dateAbonnement,codeSecret) VALUES (8,"FONTAINE","Marc","1997-07-27","h","2022-04-07","9645");

/*Retourne les locations avec les informations du propriètaires */
SELECT * FROM Locations NATURAL JOIN Client LEFT JOIN Abonne USING (idClient);

/*Ajoute un velo à une location x*/
INSERT INTO LocationsDetail (idLocations,idVelo,prix,depart,arrivee,debut,fin,fini) VALUES (1,17,null,1,5,"2022-03-26 18:37:00","2022-03-26 18:39:00",1);

/*Ajoute une location*/
INSERT INTO Locations (idClient,prix,codeSecret,fini) VALUES (1,null,null,0);

/*Modifie le pris d'une locations*/
UPDATE Locations SET prix = 18 WHERE (idLocations = 1);

/*Modifie le pris d'une location*/
UPDATE LocationsDetail SET prix = 18 WHERE (idLocationsDetail = 1);