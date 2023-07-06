package edu.datascientest.library_project.exemplaire;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.datascientest.library_project.abonne.Abonne;
import edu.datascientest.library_project.emprunt.Emprunt;
import edu.datascientest.library_project.ouvrage.Ouvrage;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_exemplaire", nullable = false)
    private Integer id_exemplaire;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @ManyToOne(targetEntity= Ouvrage.class, fetch = FetchType.EAGER)
    @JoinColumn(name="id_ouvrage")
    @JsonBackReference(value="exemplaire-ouvrage")
    private Ouvrage ouvrage;

    @OneToMany(mappedBy="exemplaire")
    @JsonBackReference(value="exemplaire-emprunts")
    private List<Emprunt> emprunts;



    public Exemplaire() {
    }

    public Exemplaire(Integer id_exemplaire, Etat etat, Ouvrage ouvrage, List<Emprunt> emprunts) {
        this.id_exemplaire = id_exemplaire;
        this.etat = etat;
        this.ouvrage = ouvrage;
        this.emprunts = emprunts;
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

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
