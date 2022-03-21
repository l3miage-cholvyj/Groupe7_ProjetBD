DROP TABLE IF EXISTS utilisateur;

CREATE TABLE utilisateur
(
    id INT PRIMARY KEY NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100)
);

INSERT INTO utilisateur (id,nom,prenom) 
    VALUES 
        (1,'CHOLVY', 'Jordan'),
        (2,'DIALLO', 'Thierno'),
        (3,'MARTINS', 'Yohan');