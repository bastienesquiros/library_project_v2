package edu.datascientest.library_project.exemplaire;

import edu.datascientest.library_project.ouvrage.Ouvrage;

public class ExemplaireDto {

    private Integer id_exemplaire;
    private Etat etat;
    private String nomOuvrage;

    public ExemplaireDto() {
    }

    public ExemplaireDto(Integer id_exemplaire, Etat etat, String nomOuvrage) {
        this.id_exemplaire = id_exemplaire;
        this.etat = etat;
        this.nomOuvrage = nomOuvrage;
    }

    public Integer getId_exemplaire() {
        return id_exemplaire;
    }

    public void setId_exemplaire(Integer id_exemplaire) {
        this.id_exemplaire = id_exemplaire;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public String getNomOuvrage() {
        return nomOuvrage;
    }

    public void setNomOuvrage(String nomOuvrage) {
        this.nomOuvrage = nomOuvrage;
    }
}
