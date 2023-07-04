package edu.datascientest.library_project.exemplaire;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.datascientest.library_project.ouvrage.Ouvrage;
import jakarta.persistence.*;

@Entity
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_exemplaire", nullable = false)
    private Integer id_exemplaire;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @ManyToOne(targetEntity= Ouvrage.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="id_ouvrage")
    @JsonBackReference
    private Ouvrage ouvrage;

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

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id_exemplaire=" + id_exemplaire +
                ", etat='" + etat + '\'' +
                ", ouvrage=" + ouvrage +
                '}';
    }

}
