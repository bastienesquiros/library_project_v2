package edu.datascientest.library_project.abonne;

import edu.datascientest.library_project.ouvrage.Ouvrage;
import edu.datascientest.library_project.utilisateur.Utilisateur;

import java.sql.Date;
import java.util.List;

public class AbonneDto {
    private Integer id_abonne;
    private Integer nb_infraction;
    private Date date_debut_penalite;
    private Date date_fin_penalite;
    private Utilisateur utilisateur;
    private List<Ouvrage> ouvrages;
}
