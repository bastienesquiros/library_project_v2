package edu.datascientest.library_project.exemplaire;

import edu.datascientest.library_project.ouvrage.Ouvrage;
import jakarta.persistence.*;

@Entity
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_exemplaire", nullable = false)
    private Integer id_exemplaire;

    private String etat;
    @ManyToOne
    @JoinColumn(name="id_ouvrage")
    private Ouvrage ouvrage;

    public Integer getId_exemplaire() {
        return id_exemplaire;
    }

    public void setId_exemplaire(Integer id_exemplaire) {
        this.id_exemplaire = id_exemplaire;
    }
}
