package edu.datascientest.library_project.auteur;

import edu.datascientest.library_project.ouvrage.Ouvrage;

import java.util.List;

public class AuteurDto {
    private Integer id;
    private String nom;
    private List<Ouvrage> ouvrages;

    public static AuteurDto convertToDto(Auteur auteur){
        AuteurDto dto = new AuteurDto();
        dto.setId(auteur.getId());
        dto.setNom(auteur.getNom());
        dto.setOuvrages(auteur.getOuvrages());
        return dto;
    }

    public AuteurDto() {
    }

    public AuteurDto(Integer id, String nom, List<Ouvrage> ouvrages) {
        this.id = id;
        this.nom = nom;
        this.ouvrages = ouvrages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void setOuvrages(List<Ouvrage> ouvrages) {
        this.ouvrages = ouvrages;
    }

    @Override
    public String toString() {
        return "AuteurDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ouvrages=" + ouvrages +
                '}';
    }
}
