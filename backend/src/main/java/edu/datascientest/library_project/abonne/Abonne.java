package edu.datascientest.library_project.abonne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.datascientest.library_project.emprunt.Emprunt;
import edu.datascientest.library_project.ouvrage.Ouvrage;
import edu.datascientest.library_project.utilisateur.Utilisateur;
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

    @OneToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "reserve",
            joinColumns = @JoinColumn(name = "id_abonne"),
            inverseJoinColumns = @JoinColumn(name = "id_ouvrage"))
    private List<Ouvrage> ouvrages;

    @OneToMany(mappedBy = "abonne")
    @JsonIgnore
    private List<Emprunt> emprunts;


    public Abonne() {
    }

    public Abonne(Integer id_abonne, Integer nb_infraction, Date date_debut_penalite, Date date_fin_penalite, Utilisateur utilisateur, List<Ouvrage> ouvrages, List<Emprunt> emprunts) {
        this.id_abonne = id_abonne;
        this.nb_infraction = nb_infraction;
        this.date_debut_penalite = date_debut_penalite;
        this.date_fin_penalite = date_fin_penalite;
        this.utilisateur = utilisateur;
        this.ouvrages = ouvrages;
        this.emprunts = emprunts;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void setOuvrages(List<Ouvrage> ouvrages) {
        this.ouvrages = ouvrages;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonne abonne = (Abonne) o;
        return Objects.equals(getId_abonne(), abonne.getId_abonne()) && Objects.equals(getNb_infraction(), abonne.getNb_infraction()) && Objects.equals(getDate_debut_penalite(), abonne.getDate_debut_penalite()) && Objects.equals(getDate_fin_penalite(), abonne.getDate_fin_penalite()) && Objects.equals(getUtilisateur(), abonne.getUtilisateur()) && Objects.equals(getOuvrages(), abonne.getOuvrages()) && Objects.equals(getEmprunts(), abonne.getEmprunts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_abonne(), getNb_infraction(), getDate_debut_penalite(), getDate_fin_penalite(), getUtilisateur(), getOuvrages(), getEmprunts());
    }
}
