-- Suppression des tables existantes si elles existent
DROP TABLE IF EXISTS JOParticiperResultat;
DROP TABLE IF EXISTS JOSinscrire;
DROP TABLE IF EXISTS JOAthlete;
DROP TABLE IF EXISTS JOEquipe;
DROP TABLE IF EXISTS JOAnimer;
DROP TABLE IF EXISTS JOOrganiser;
DROP TABLE IF EXISTS JOHeberger;
DROP TABLE IF EXISTS JOParticiper;
DROP TABLE IF EXISTS JOJeuxOlympique;
DROP TABLE IF EXISTS JOEpreuve;
DROP TABLE IF EXISTS JOSport;
DROP TABLE IF EXISTS JOPays;
DROP TABLE IF EXISTS JOUtilisateur;

-- Création des tables
CREATE TABLE JOUtilisateur (
    idUser INT PRIMARY KEY,
    nomUser VARCHAR(50),
    prenomUser VARCHAR(50),
    mdpUser VARCHAR(50),
    roleUser VARCHAR(50)
);

CREATE TABLE JOPays (
    idPays INT PRIMARY KEY,
    nomPays VARCHAR(50)
);

CREATE TABLE JOSport (
    idSport INT PRIMARY KEY,
    nomSport VARCHAR(50),
    unite VARCHAR(20),
    coefForce FLOAT,
    coefAgilite FLOAT,
    coefEndurance FLOAT
);

CREATE TABLE JOEpreuve (
    idEpreuve INT PRIMARY KEY,
    nomEpreuve VARCHAR(50),
    sexeEpreuve CHAR(1),
    dateEpreuve DATE,
    idSport INT,
    nombreAthletes INT,
    FOREIGN KEY (idSport) REFERENCES JOSport(idSport)
);

CREATE TABLE JOJeuxOlympique (
    idJO INT PRIMARY KEY,
    dateJO DATE
);

CREATE TABLE JOParticiper (
    idEpreuve INT,
    idJO INT,
    PRIMARY KEY (idEpreuve, idJO),
    FOREIGN KEY (idEpreuve) REFERENCES JOEpreuve(idEpreuve),
    FOREIGN KEY (idJO) REFERENCES JOJeuxOlympique(idJO)
);

CREATE TABLE JOHeberger (
    idJO INT,
    idPays INT,
    PRIMARY KEY (idJO, idPays),
    FOREIGN KEY (idJO) REFERENCES JOJeuxOlympique(idJO),
    FOREIGN KEY (idPays) REFERENCES JOPays(idPays)
);

CREATE TABLE JOOrganiser (
    idJO INT,
    idEpreuve INT,
    PRIMARY KEY (idJO, idEpreuve),
    FOREIGN KEY (idJO) REFERENCES JOJeuxOlympique(idJO),
    FOREIGN KEY (idEpreuve) REFERENCES JOEpreuve(idEpreuve)
);

CREATE TABLE JOAnimer (
    idJO INT,
    idSport INT,
    PRIMARY KEY (idJO, idSport),
    FOREIGN KEY (idJO) REFERENCES JOJeuxOlympique(idJO),
    FOREIGN KEY (idSport) REFERENCES JOSport(idSport)
);

CREATE TABLE JOEquipe (
    idEq INT PRIMARY KEY,
    nomEq VARCHAR(50),
    idPays INT,
    FOREIGN KEY (idPays) REFERENCES JOPays(idPays)
);

CREATE TABLE JOAthlete (
    idAthlete INT PRIMARY KEY,
    prenomAthlete VARCHAR(50),
    nomAthlete VARCHAR(50),
    sexeAthlete CHAR(1),
    forceAthlete INT,
    agiliteAthlete INT,
    enduranceAthlete INT,
    idPays INT,
    idEq INT,
    FOREIGN KEY (idPays) REFERENCES JOPays(idPays),
    FOREIGN KEY (idEq) REFERENCES JOEquipe(idEq)
);


CREATE TABLE JOSinscrire (
    idInscription INT PRIMARY KEY,
    idAthlete INT,
    idEq INT,
    idEpreuve INT,
    FOREIGN KEY (idAthlete) REFERENCES JOAthlete(idAthlete),
    FOREIGN KEY (idEq) REFERENCES JOEquipe(idEq),
    FOREIGN KEY (idEpreuve) REFERENCES JOEpreuve(idEpreuve),
    CHECK ((idAthlete IS NOT NULL AND idEq IS NULL) OR (idAthlete IS NULL AND idEq IS NOT NULL))
);

CREATE TABLE JOParticiperResultat (
    idResultat INT PRIMARY KEY,
    idInscription INT,
    resultat FLOAT,
    FOREIGN KEY (idInscription) REFERENCES JOSinscrire(idInscription)
);
