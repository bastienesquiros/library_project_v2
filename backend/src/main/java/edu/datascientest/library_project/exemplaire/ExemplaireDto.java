package edu.datascientest.library_project.exemplaire;

import edu.datascientest.library_project.ouvrage.Ouvrage;

public class ExemplaireDto {

    private Integer id_exemplaire;
    private Etat etat;
    private Ouvrage ouvrage;

    public static ExemplaireDto convertToDto(Exemplaire exemplaire){
        ExemplaireDto dto = new ExemplaireDto();
        dto.setId_exemplaire(exemplaire.getId_exemplaire());
        dto.setEtat(exemplaire.getEtat());
        dto.setOuvrage(exemplaire.getOuvrage());
        return dto;
    }

    public ExemplaireDto() {
    }

    public ExemplaireDto(Integer id_exemplaire, Etat etat, Ouvrage ouvrage) {
        this.id_exemplaire = id_exemplaire;
        this.etat = etat;
        this.ouvrage = ouvrage;
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

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }
}
