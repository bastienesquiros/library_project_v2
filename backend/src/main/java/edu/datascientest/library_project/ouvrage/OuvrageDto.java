package edu.datascientest.library_project.ouvrage;

import edu.datascientest.library_project.abonne.Abonne;
import edu.datascientest.library_project.auteur.Auteur;
import edu.datascientest.library_project.exemplaire.Exemplaire;
import edu.datascientest.library_project.type_ouvrage.TypeOuvrage;

import java.util.List;

public class OuvrageDto {
    private Integer id_ouvrage;
    private String titre;

    private TypeOuvrage typeOuvrage;

    private List<Auteur> auteurs;

    private List<Abonne> abonnes; //pour la table reserve

    private List<Exemplaire> exemplaires;

    public static OuvrageDto convertToDto(Ouvrage ouvrage){
        OuvrageDto dto = new OuvrageDto();

        dto.setId_ouvrage(ouvrage.getId_ouvrage());
        dto.setTitre(ouvrage.getTitre());
        dto.setTypeOuvrage(ouvrage.getTypeOuvrage());
        dto.setAuteurs(ouvrage.getAuteurs());
        dto.setAuteurs(ouvrage.getAuteurs());
        dto.setExemplaires(ouvrage.getExemplaires());

        return dto;
    }

    public OuvrageDto() {
    }

////////


    public OuvrageDto(Integer id_ouvrage, String titre, TypeOuvrage typeOuvrage, List<Auteur> auteurs, List<Abonne> abonnes, List<Exemplaire> exemplaires) {
        this.id_ouvrage = id_ouvrage;
        this.titre = titre;
        this.typeOuvrage = typeOuvrage;
        this.auteurs = auteurs;
        this.abonnes = abonnes;
        this.exemplaires = exemplaires;
    }

    public Integer getId_ouvrage() {
        return id_ouvrage;
    }

    public void setId_ouvrage(Integer id_ouvrage) {
        this.id_ouvrage = id_ouvrage;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public TypeOuvrage getTypeOuvrage() {
        return typeOuvrage;
    }

    public void setTypeOuvrage(TypeOuvrage typeOuvrage) {
        this.typeOuvrage = typeOuvrage;
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(List<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    public List<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(List<Abonne> abonnes) {
        this.abonnes = abonnes;
    }

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
}
