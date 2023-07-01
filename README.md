# library_project_v2 - Projet fin formation
# SCRIPT SQL

CREATE DATABASE library_project_v2;

CREATE USER 'library_admin'@'localhost' IDENTIFIED BY 'library_Admin1234@';

GRANT ALL PRIVILEGES ON library_project_v2.* TO 'library_admin'@'localhost';

USE library_project_v2;

CREATE TABLE Utilisateur(
id_utilisateur INT AUTO_INCREMENT UNIQUE,
login VARCHAR(50) NOT NULL,
mot_de_passe VARCHAR(50) NOT NULL,
bibliothecaire BOOLEAN NOT NULL,
prenom VARCHAR(50) NOT NULL,
adresse VARCHAR(50) NOT NULL,
nom VARCHAR(50) NOT NULL,
PRIMARY KEY(id_utilisateur),
UNIQUE(login)
);

CREATE TABLE Abonne(
id_abonne INT AUTO_INCREMENT UNIQUE,
nb_infraction INT,
date_debut_penalite DATE,
date_fin_penalite DATE,
id_utilisateur INT NOT NULL,
PRIMARY KEY(id_abonne),
UNIQUE(id_utilisateur),
FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Type_Ouvrage(
id_type INT AUTO_INCREMENT UNIQUE,
type VARCHAR(50) NOT NULL,
PRIMARY KEY(id_type),
UNIQUE(type)
);

CREATE TABLE Ouvrage(
id_ouvrage INT AUTO_INCREMENT UNIQUE,
titre VARCHAR(50) NOT NULL,
auteur VARCHAR(50) NOT NULL,
id_type INT NOT NULL,
PRIMARY KEY(id_ouvrage),
FOREIGN KEY(id_type) REFERENCES Type_Ouvrage(id_type) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Exemplaire(
id_exemplaire INT AUTO_INCREMENT UNIQUE,
etat VARCHAR(50) NOT NULL,
id_ouvrage INT NOT NULL,
CHECK(etat IN ('Neuf', 'Normal', 'Abimé')),
PRIMARY KEY(id_exemplaire),
FOREIGN KEY(id_ouvrage) REFERENCES Ouvrage(id_ouvrage) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Auteur(
id_auteur INT AUTO_INCREMENT UNIQUE,
nom VARCHAR(50) NOT NULL,
PRIMARY KEY(id_auteur) );
CREATE TABLE Reserve(
id_abonne INT,
id_ouvrage INT,
PRIMARY KEY(id_abonne, id_ouvrage),
FOREIGN KEY(id_abonne) REFERENCES Abonne(id_abonne) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(id_ouvrage) REFERENCES Ouvrage(id_ouvrage) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Ecrire(
id_ouvrage INT,
id_auteur INT,
PRIMARY KEY(id_ouvrage, id_auteur),
FOREIGN KEY(id_ouvrage) REFERENCES Ouvrage(id_ouvrage)ON UPDATE CASCADE ON DELETE CASCADE
,
FOREIGN KEY(id_auteur) REFERENCES Auteur(id_auteur) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Emprunt(
id_exemplaire INT,
id_emprunt INT NOT NULL,
date_debut_emprunt DATE NOT NULL,
date_fin_emprunt_attendue DATE NOT NULL,
date_fin_emprunt_reel DATE DEFAULT NULL,
id_abonne INT NOT NULL,
PRIMARY KEY(id_emprunt),
FOREIGN KEY(id_exemplaire) REFERENCES Exemplaire(id_exemplaire) ON UPDATE CASCADE ON DELETE CASCADE
,
FOREIGN KEY(id_abonne) REFERENCES Abonne(id_abonne) ON UPDATE CASCADE ON DELETE CASCADE
);




























