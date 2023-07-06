package edu.datascientest.library_project.emprunt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.datascientest.library_project.abonne.Abonne;
import edu.datascientest.library_project.exemplaire.Exemplaire;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_emprunt;

    @ManyToOne
    @JoinColumn(name="id_abonne")  
    @JsonIgnore
    private Abonne abonne;

    @ManyToOne
    @JoinColumn(name = "id_exemplaire")	@JsonBackReference
    private Exemplaire exemplaire;

    private Date date_debut_emprunt;
    private Date date_fin_emprunt_attendue;

    private Date date_fin_emprunt_reel;

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }


    public Emprunt() {}

    public Emprunt(Integer id_emprunt, Abonne abonne, Exemplaire exemplaire, Date date_debut_emprunt, Date date_fin_emprunt_attendue, Date date_fin_emprunt_reel) {
        this.id_emprunt = id_emprunt;
        this.abonne = abonne;
        this.exemplaire = exemplaire;
        this.date_debut_emprunt = date_debut_emprunt;
        this.date_fin_emprunt_attendue = date_fin_emprunt_attendue;
        this.date_fin_emprunt_reel = date_fin_emprunt_reel;
    }

    public Integer getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(Integer id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
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

	@Override
	public String toString() {
		return "Emprunt [id_emprunt=" + id_emprunt + ", abonne=" + abonne + ", exemplaire=" + exemplaire
				+ ", date_debut_emprunt=" + date_debut_emprunt + ", date_fin_emprunt_attendue="
				+ date_fin_emprunt_attendue + ", date_fin_emprunt_reel=" + date_fin_emprunt_reel + "]";
	}
    
    
}
