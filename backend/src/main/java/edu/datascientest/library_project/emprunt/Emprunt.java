package edu.datascientest.library_project.emprunt;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Emprunt {
    private Date date_debut_emprunt;
    private Date date_fin_emprunt_attendue;

    private Date date_fin_emprunt_reel;


    @Column(name = "id_abonne")
    private Integer id_abonne;


    private Integer id_exemplaire;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_emprunt;

    public Emprunt() {

    }

    public Emprunt(Date date__debut_emprunt, Date date_fin_emprunt_attendue, Date date_fin_emprunt_reel, Integer id_abonne, Integer id_exemplaire, Integer id_emprunt) {
        this.date_debut_emprunt = date__debut_emprunt;
        this.date_fin_emprunt_attendue = date_fin_emprunt_attendue;
        this.date_fin_emprunt_reel = date_fin_emprunt_reel;
        this.id_abonne = id_abonne;
        this.id_exemplaire = id_exemplaire;
        this.id_emprunt = id_emprunt;
    }

    public Date getDate__debut_emprunt() {
        return date_debut_emprunt;
    }

    public void setDate__debut_emprunt(Date date__debut_emprunt) {
        this.date_debut_emprunt = date__debut_emprunt;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "date__debut_emprunt=" + date_debut_emprunt +
                ", date_fin_emprunt_attendue=" + date_fin_emprunt_attendue +
                ", date_fin_emprunt_reel=" + date_fin_emprunt_reel +
                ", id_abonne=" + id_abonne +
                ", id_exemplaire=" + id_exemplaire +
                ", id_emprunt=" + id_emprunt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprunt emprunt = (Emprunt) o;
        return Objects.equals(date_debut_emprunt, emprunt.date_debut_emprunt) && Objects.equals(date_fin_emprunt_attendue, emprunt.date_fin_emprunt_attendue) && Objects.equals(date_fin_emprunt_reel, emprunt.date_fin_emprunt_reel) && Objects.equals(id_abonne, emprunt.id_abonne) && Objects.equals(id_exemplaire, emprunt.id_exemplaire) && Objects.equals(id_emprunt, emprunt.id_emprunt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date_debut_emprunt, date_fin_emprunt_attendue, date_fin_emprunt_reel, id_abonne, id_exemplaire, id_emprunt);
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

    public Integer getId_abonne() {
        return id_abonne;
    }

    public void setId_abonne(Integer id_abonne) {
        this.id_abonne = id_abonne;
    }

    public Integer getId_exemplaire() {
        return id_exemplaire;
    }

    public void setId_exemplaire(Integer id_exemplaire) {
        this.id_exemplaire = id_exemplaire;
    }

    public Integer getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(Integer id_emprunt) {
        this.id_emprunt = id_emprunt;
    }
}
