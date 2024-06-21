-- Suppression des tables existantes si elles existent
DROP TABLE IF EXISTS JOParticiperResultat;
DROP TABLE IF EXISTS JOSinscrire;
DROP TABLE IF EXISTS JOAnimer;
DROP TABLE IF EXISTS JOOrganiser;
DROP TABLE IF EXISTS JOHeberger;
DROP TABLE IF EXISTS JOParticiper;
DROP TABLE IF EXISTS JOSintegrer;
DROP TABLE IF EXISTS JOJeuxOlympique;
DROP TABLE IF EXISTS JOEpreuve;
DROP TABLE IF EXISTS JOSport;
DROP TABLE IF EXISTS JOAthlete;
DROP TABLE IF EXISTS JOEquipe;
DROP TABLE IF EXISTS JOPays;
DROP TABLE IF EXISTS JOUtilisateur;

-- Création des tables
CREATE TABLE JOUtilisateur (
    emailUser VARCHAR(50) PRIMARY KEY,
    nomUser VARCHAR(50),
    mdpUser VARCHAR(50),
    roleUser VARCHAR(50)
);

CREATE TABLE JOPays ( -- Traduit en JDBC
    idPays INT PRIMARY KEY,
    nomPays VARCHAR(50)
);

CREATE TABLE JOSport ( -- Traduit en JDBC
    idSport INT PRIMARY KEY,
    nomSport VARCHAR(50),
    unite VARCHAR(20),
    coefForce DOUBLE,
    coefAgilite DOUBLE,
    coefEndurance DOUBLE
);

CREATE TABLE JOEpreuve ( -- Traduit en JDBC
    idEpreuve INT PRIMARY KEY,
    nomEpreuve VARCHAR(50),
    sexeEpreuve CHAR(1),
    idSport INT,
    nombreAthletes INT,
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
    FOREIGN KEY (idPays) REFERENCES JOPays(idPays)
);

CREATE TABLE JOSintegrer (
    idAthlete INT,
    idEq INT,
    PRIMARY KEY (idAthlete, idEq),
    FOREIGN KEY (idAthlete) REFERENCES JOAthlete(idAthlete),
    FOREIGN KEY (idEq) REFERENCES JOEquipe(idEq)
);

CREATE TABLE JOSinscrire (
    idAthlete INT,
    idEq INT,
    idEpreuve INT,
    UNIQUE (idAthlete, idEq, idEpreuve),
    FOREIGN KEY (idAthlete) REFERENCES JOAthlete(idAthlete),
    FOREIGN KEY (idEq) REFERENCES JOEquipe(idEq),
    FOREIGN KEY (idEpreuve) REFERENCES JOEpreuve(idEpreuve),
    CHECK ((idAthlete IS NOT NULL AND idEq IS NULL) OR (idAthlete IS NULL AND idEq IS NOT NULL))
);

CREATE TABLE JOParticiperResultat (
    idResultat INT PRIMARY KEY AUTO_INCREMENT,
    resultat DOUBLE,
    idAthlete INT,
    idEq INT,
    idEpreuve INT,
    FOREIGN KEY (idAthlete) REFERENCES JOAthlete(idAthlete),
    FOREIGN KEY (idEq) REFERENCES JOEquipe(idEq),
    FOREIGN KEY (idEpreuve) REFERENCES JOEpreuve(idEpreuve),
    CHECK ((idAthlete IS NOT NULL AND idEq IS NULL) OR (idAthlete IS NULL AND idEq IS NOT NULL))
);
