-- CREATE DATABASE JeuxOlympiques;
-- USE JeuxOlympiques;

DROP TABLE ATHLETE;
DROP TABLE EPREUVE;
DROP TABLE EQUIPE;
DROP TABLE SPORT;
DROP TABLE PAYS;

CREATE TABLE PAYS (
    idPays INT PRIMARY KEY,
    nomPays VARCHAR(50) NOT NULL
);

CREATE TABLE SPORT (
    idSport INT PRIMARY KEY,
    nomSport VARCHAR(50) NOT NULL
);

CREATE TABLE EQUIPE (
    idEquipe INT PRIMARY KEY,
    nomEquipe VARCHAR(100) NOT NULL,
    idPays INT,
    FOREIGN KEY (idPays) REFERENCES PAYS(idPays)
);


CREATE TABLE EPREUVE (
    idEpreuve INT PRIMARY KEY,
    nomEpreuve VARCHAR(50),
    idSport INT,
    FOREIGN KEY (idSport) REFERENCES SPORT(idSport)
);


CREATE TABLE ATHLETE (
    idAthlete INT PRIMARY KEY,
    prenomAthlete VARCHAR(50),
    nomAthlete VARCHAR(50),
    idSexe CHAR(1),
    force_ INT,
    agilite INT,
    endurance INT,
    idPays INT,
    idEquipe INT,
    FOREIGN KEY (idPays) REFERENCES PAYS(idPays),
    FOREIGN KEY (idEquipe) REFERENCES EQUIPE(idEquipe)
);
