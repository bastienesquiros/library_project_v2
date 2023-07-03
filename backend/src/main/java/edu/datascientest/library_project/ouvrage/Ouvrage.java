package edu.datascientest.library_project.ouvrage;

import edu.datascientest.library_project.abonne.Abonne;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Ouvrage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_ouvrage;
    private String titre;
    private String auteur;
    private Integer id_type;
    @ManyToMany(mappedBy = "ouvrages")
    private List<Abonne> abonnes;

    public Ouvrage() {
    }

    @Override
    public String toString() {
        return "Ouvrage{" +
                "id_ouvrage=" + id_ouvrage +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", id_type=" + id_type +
                ", abonnes=" + abonnes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ouvrage ouvrage = (Ouvrage) o;
        return Objects.equals(id_ouvrage, ouvrage.id_ouvrage) && Objects.equals(titre, ouvrage.titre) && Objects.equals(auteur, ouvrage.auteur) && Objects.equals(id_type, ouvrage.id_type) && Objects.equals(abonnes, ouvrage.abonnes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ouvrage, titre, auteur, id_type, abonnes);
    }

    public List<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(List<Abonne> abonnes) {
        this.abonnes = abonnes;
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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }


}
