package edu.datascientest.library_project.abonne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.datascientest.library_project.ouvrage.Ouvrage;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Abonne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_abonne;
    private Integer nb_infraction;

    private Date date_debut_penalite;
    private Date date_fin_penalite;


    private Integer id_utilisateur;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "reserve",
            joinColumns = @JoinColumn(name = "id_abonne"),
            inverseJoinColumns = @JoinColumn(name = "id_ouvrage"))
    private List<Ouvrage> ouvrages;

    public Abonne() {

    }


    public Abonne(Integer id_abonne, Integer nb_infraction, Date date_debut_penalite, Date date_fin_penalite, Integer id_utilisateur) {
        this.id_abonne = id_abonne;
        this.nb_infraction = nb_infraction;
        this.date_debut_penalite = date_debut_penalite;
        this.date_fin_penalite = date_fin_penalite;
        this.id_utilisateur = id_utilisateur;
    }

    @Override
    public String toString() {
        return "Abonne{" +
                "id_abonne=" + id_abonne +
                ", nb_infraction=" + nb_infraction +
                ", date_debut_penalite=" + date_debut_penalite +
                ", date_fin_penalite=" + date_fin_penalite +
                ", id_utilisateur=" + id_utilisateur +
                ", ouvrages=" + ouvrages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonne abonne = (Abonne) o;
        return Objects.equals(id_abonne, abonne.id_abonne) && Objects.equals(nb_infraction, abonne.nb_infraction) && Objects.equals(date_debut_penalite, abonne.date_debut_penalite) && Objects.equals(date_fin_penalite, abonne.date_fin_penalite) && Objects.equals(id_utilisateur, abonne.id_utilisateur) && Objects.equals(ouvrages, abonne.ouvrages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_abonne, nb_infraction, date_debut_penalite, date_fin_penalite, id_utilisateur, ouvrages);
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void setOuvrages(List<Ouvrage> ouvrages) {
        this.ouvrages = ouvrages;
    }

    public Integer getId_abonne() {
        return id_abonne;
    }

    public void setId_abonne(Integer id_abonne) {
        this.id_abonne = id_abonne;
    }

    public Integer getNb_infraction() {
        return nb_infraction;
    }

    public void setNb_infraction(Integer nb_infraction) {
        this.nb_infraction = nb_infraction;
    }

    public Date getDate_debut_penalite() {
        return date_debut_penalite;
    }

    public void setDate_debut_penalite(Date date_debut_penalite) {
        this.date_debut_penalite = date_debut_penalite;
    }

    public Date getDate_fin_penalite() {
        return date_fin_penalite;
    }

    public void setDate_fin_penalite(Date date_fin_penalite) {
        this.date_fin_penalite = date_fin_penalite;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
}
