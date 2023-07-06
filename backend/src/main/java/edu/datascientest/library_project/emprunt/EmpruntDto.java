package edu.datascientest.library_project.emprunt;

import edu.datascientest.library_project.abonne.Abonne;
import edu.datascientest.library_project.exemplaire.Exemplaire;

import java.sql.Date;

public class EmpruntDto {
    private Integer id_emprunt;
    private Date date_debut_emprunt;
    private Date date_fin_emprunt_attendue;
    private Date date_fin_emprunt_reel;

    private Abonne abonne;
    private Exemplaire exemplaire;

    private EtatEmprunt etatEmprunt;


    public EmpruntDto() {
    }

    public EmpruntDto(Integer id_emprunt, Date date_debut_emprunt, Date date_fin_emprunt_attendue, Date date_fin_emprunt_reel, Abonne abonne, Exemplaire exemplaire, EtatEmprunt etatEmprunt) {
        this.id_emprunt = id_emprunt;
        this.date_debut_emprunt = date_debut_emprunt;
        this.date_fin_emprunt_attendue = date_fin_emprunt_attendue;
        this.date_fin_emprunt_reel = date_fin_emprunt_reel;
        this.abonne = abonne;
        this.exemplaire = exemplaire;
        this.etatEmprunt = etatEmprunt;
    }

    public static EmpruntDto convertToDto(Emprunt emprunt) {
        EmpruntDto dto = new EmpruntDto();
        dto.setId_emprunt(emprunt.getId_emprunt());
        dto.setDate_debut_emprunt(emprunt.getDate_debut_emprunt());
        dto.setDate_fin_emprunt_attendue(emprunt.getDate_fin_emprunt_attendue());
        dto.setDate_fin_emprunt_reel(emprunt.getDate_fin_emprunt_reel());
        dto.setAbonne(emprunt.getAbonne());
        dto.setExemplaire(emprunt.getExemplaire());

        return dto;
    }

    public Integer getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(Integer id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public Date getDate_debut_emprunt() {
        return date_debut_emprunt;
    }

    public void setDate_debut_emprunt(Date date_debut_emprunt) {
        this.date_debut_emprunt = date_debut_emprunt;
    }

    public Date getDate_fin_emprunt_attendue() {
        return date_fin_emprunt_attendue;
    }

    public void setDate_fin_emprunt_attendue(Date date_fin_emprunt_attendue) {
        this.date_fin_emprunt_attendue = date_fin_emprunt_attendue;
    }

    public Date getDate_fin_emprunt_reel() {
        return date_fin_emprunt_reel;
    }

    public void setDate_fin_emprunt_reel(Date date_fin_emprunt_reel) {
        this.date_fin_emprunt_reel = date_fin_emprunt_reel;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public EtatEmprunt getEtatEmprunt() {
        return etatEmprunt;
    }

    public void setEtatEmprunt(EtatEmprunt etatEmprunt) {
        this.etatEmprunt = etatEmprunt;
    }
}
