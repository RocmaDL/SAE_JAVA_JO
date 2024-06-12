--CREATE DATABASE JeuxOlympiques; (A tester plus tard)
--USE JeuxOlympiques; 

--Pour plus tard : choisir un ordre logique 
CREATE TABLE Pays (
    idPays INT PRIMARY KEY,
    nomPays VARCHAR(30) not null
);

CREATE TABLE Sport (
    idSport INT PRIMARY KEY,
    nomSport VARCHAR(15) NOT NULL
);

CREATE TABLE Epreuve (
    idEpreuve INT PRIMARY KEY,
    nomEpreuve VARCHAR(100) NOT NULL,
    idSport INT,
    genreEpreuve ENUM('Homme', 'Femme'),   -- Enumération , homme ou femme (pas de "NOT NULL")
    typeEpreuve ENUM('Individuel', 'Collectif'),
    FOREIGN KEY (idSport) REFERENCES Sport(idSport)
);

CREATE TABLE Athlete (
    idAthlete INT PRIMARY KEY,
    prenomAthlete VARCHAR(20) NOT NULL,
    nomAthlete VARCHAR(20) NOT NULL,
    idPays INT,
    genre ENUM('Homme' , 'Femme') NOT NULL   -- Enumération , homme ou femme
    force INT CHECK (force >= 0 AND force <= 5),
    agilite INT CHECK (agilite >= 0 AND agilite <= 5),          --Valeur entre 0 et 5
    endurance INT CHECK (endurance >= 0 AND endurance <= 5),
    FOREIGN KEY (idPays) REFERENCES Pays(idPays)
);

CREATE TABLE Equipe (
    idEquipe INT PRIMARY KEY,
    nomEquipe VARCHAR(10),
    idEpreuve INT,
    idPays INT,
    FOREIGN KEY (idEpreuve) REFERENCES Epreuve(idEpreuve),
    FOREIGN KEY (idPays) REFERENCES Pays(idPays)
);

CREATE TABLE PARTCIPER (
    idEpreuve INT,
    idEquipe INT,
    FOREIGN KEY (idEpreuve) REFERENCES Epreuve(idEpreuve),
    FOREIGN KEY (idEquipe) REFERENCES Equipe(idEquipe),

);
CREATE TABLE Resultat (
    idResultat INT PRIMARY KEY,
    idEpreuve INT,
    idEquipe INT,
    rang INT,
    temps VARCHAR(10),
    FOREIGN KEY (idEpreuve) REFERENCES Epreuve(idEpreuve),
    FOREIGN KEY (idEquipe) REFERENCES Equipe(idEquipe)
);



                                    --MCD--

                                 
--Epreuve (1) ----(PLUSIEUR) Sport ----- Pays (PLUSIEUR) ------- (1) Athlete
    --                              --(PLUSIEUR)
      --                            --  |
        --                          --  |
          --                        --  |
            --                      -Epreuve- (1)
        --PARTCIPER------------(1)--Equipe





--Insertion de valeurs ( SUIVRE LA L'ORDRE DE LA CREATION DES TABLES)

--Insertion Pays

INSERT INTO Pays VALUES(1,"France");
INSERT INTO Pays VALUES(2,"Allemagne");
INSERT INTO Pays VALUES(3,"Espagne");
INSERT INTO Pays VALUES(4,"Italie");
INSERT INTO Pays VALUES(5,"Chine");
INSERT INTO Pays VALUES(6,"Angleterre");
INSERT INTO Pays VALUES(7,"Japon");
INSERT INTO Pays VALUES(8,"Belgique");


--Insertion Sport

INSERT INTO Sport VALUES(1,"Natation");
INSERT INTO Sport VALUES(2,"Athlétisme");
INSERT INTO Sport VALUES(3,"Volley-ball");
INSERT INTO Sport VALUES(4,"Escrime");
INSERT INTO Sport VALUES(5,"Handball");

--Insertion Epreuve

INSERT INTO Epreuve VALUES (1, '100m brasse', 1, 'Homme', 'Individuel');
INSERT INTO Epreuve VALUES (2, '100m brasse', 1, 'Femme', 'Individuel');
INSERT INTO Epreuve VALUES (3, '4x100m nage libre', 1, 'Homme', 'Collectif');
INSERT INTO Epreuve VALUES (4, '4x100m nage libre', 1, 'Femme', 'Collectif');
INSERT INTO Epreuve VALUES (5, '4x100m relais', 2, 'Homme', 'Collectif');
INSERT INTO Epreuve VALUES (6, '4x100m relais', 2, 'Femme', 'Collectif');
INSERT INTO Epreuve VALUES (7, '110m haies', 2, 'Homme', 'Individuel');
INSERT INTO Epreuve VALUES (8, '110m haies', 2, 'Femme', 'Individuel');
INSERT INTO Epreuve VALUES (9, 'fleuret', 4, 'Homme', 'Individuel');
INSERT INTO Epreuve VALUES (10, 'fleuret', 4, 'Femme', 'Individuel');
INSERT INTO Epreuve VALUES (11, 'épée', 4, 'Homme', 'Individuel');
INSERT INTO Epreuve VALUES (12, 'épée', 4, 'Femme', 'Individuel');
INSERT INTO Epreuve VALUES (13, 'Handball', 5, 'Homme', 'Collectif');
INSERT INTO Epreuve VALUES (14, 'Handball', 5, 'Femme', 'Collectif');
INSERT INTO Epreuve VALUES (15, 'Volley-ball', 3, 'Homme', 'Collectif');
INSERT INTO Epreuve VALUES (16, 'Volley-ball', 3, 'Femme', 'Collectif');


--Insertion Athlete

INSERT INTO Athlete VALUES (1, 'Rocma', 'DIMBA LAU', 1, 'Homme', 3, 4, 2);
INSERT INTO Athlete VALUES (2, 'Alexandre', 'GLEIZES', 1, 'Homme', 4, 3, 4);
INSERT INTO Athlete VALUES (3, 'Youssef', 'KHADJOU', 2, 'Homme', 5, 2, 3);
INSERT INTO Athlete VALUES (4, 'Lenny', 'VERGEROLLE', 2, 'Homme', 2, 5, 4);
INSERT INTO Athlete VALUES (5, 'Ophélie', 'VALIN', 1, 'Femme', 3, 4, 5);

--Insertion Equipe

INSERT INTO Equipe VALUES (1, 'Team A', 3, 1);
INSERT INTO Equipe VALUES (2, 'Team B', 4, 2);
INSERT INTO Equipe VALUES (3, 'Team C', 5, 3);
INSERT INTO Equipe VALUES (4, 'Team D', 6, 4);


--Insertion PARTICIPER


INSERT INTO PARTICIPER VALUES (1, 1);
INSERT INTO PARTICIPER VALUES (2, 2);
INSERT INTO PARTICIPER VALUES (3, 3);
INSERT INTO PARTICIPER VALUES (4, 4);

--Insertion Resultat


INSERT INTO Resultat VALUES (1, 1, 1, 1, '00:50.00');
INSERT INTO Resultat VALUES (2, 2, 2, 2, '01:45.00');
INSERT INTO Resultat VALUES (3, 3, 3, 1, '03:15.00');
INSERT INTO Resultat VALUES (4, 4, 4, 2, '04:05.00');
