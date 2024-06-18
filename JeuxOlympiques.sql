--CREATE DATABASE JeuxOlympiques;
--USE JeuxOlympiques; 

CREATE TABLE ATHLETE (
    idAthlete INT PRIMARY KEY,
    prenom VARCHAR(50),
    nom VARCHAR(50),
    sexe CHAR(1),
    force_ INT,
    agilite INT,
    endurance INT,
    pays VARCHAR(50)
);

CREATE TABLE EPREUVE (
    idEpreuve INT PRIMARY KEY,
    nom VARCHAR(50)
);

CREATE TABLE RESULTAT (
    idResultat INT PRIMARY KEY,
    idAthlete INT,
    idEpreuve INT,
    score DECIMAL(10,2),
    rang INT,
    FOREIGN KEY (idAthlete) REFERENCES ATHLETE(idAthlete),
    FOREIGN KEY (idEpreuve) REFERENCES EPREUVE(idEpreuve)
);