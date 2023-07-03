package edu.datascientest.library_project.utilisateur;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_utilisateur;

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 5, max = 100, message = "Le nom doit être compris entre 5 et 100 caractères")
    private String nom;

    @NotBlank(message = "L'adresse ne peut pas être vide")
    @Size(min = 5, max = 100, message = "L'adresse doit être comprise entre 5 et 100 caractères")
    private String adresse;

    @NotBlank(message = "Le login ne peut pas être vide")
    @Size(min = 5, max = 100, message = "Le login doit être compris entre 5 et 100 caractères")
    private String login;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    @Size(min = 5, max = 100, message = "Le mot de passe doit être compris entre 5 et 100 caractères")
    private String mot_de_passe;

    @NotBlank(message = "Le prénom ne peut pas être vide")
    @Size(min = 5, max = 100, message = "Le prénom doit être compris entre 5 et 100 caractères")
    private String prenom;

<<<<<<< HEAD
    @NotNull(message = "Le champ bibliothequaire ne peut pas être vide")
=======
    @NotNull(message = "Le champ bibliothecaire ne peut pas être vide")
>>>>>>> 66d6a8cf3e12c26ffbd6ee71f8d9ec50f56bffb3
    private boolean bibliothecaire;

    public Utilisateur(String nom, String adresse, String login, String mot_de_passe, String prenom, boolean bibliothecaire) {
        this.nom = nom;
        this.adresse = adresse;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
        this.prenom = prenom;
        this.bibliothecaire = bibliothecaire;
    }

    public Utilisateur(Integer id_utilisateur, String nom) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
    }

    protected Utilisateur() {

    }

    public Utilisateur(String login, String mot_de_passe) {
        this.login = login;
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_utilisateur=" + id_utilisateur +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", login='" + login + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", prenom='" + prenom + '\'' +
                ", bibliothecaire=" + bibliothecaire +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return bibliothecaire == that.bibliothecaire && Objects.equals(id_utilisateur, that.id_utilisateur) && Objects.equals(nom, that.nom) && Objects.equals(adresse, that.adresse) && Objects.equals(login, that.login) && Objects.equals(mot_de_passe, that.mot_de_passe) && Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_utilisateur, nom, adresse, login, mot_de_passe, prenom, bibliothecaire);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isBibliothecaire() {
        return bibliothecaire;
    }

<<<<<<< HEAD
    public void setBibliothequaire(boolean bibliothequaire) {
=======
    public void setBibliothecaire(boolean bibliothecaire) {
>>>>>>> 66d6a8cf3e12c26ffbd6ee71f8d9ec50f56bffb3
        this.bibliothecaire = bibliothecaire;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
}
