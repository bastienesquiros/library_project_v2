package edu.datascientest.library_project.auteur;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.datascientest.library_project.ouvrage.Ouvrage;
import jakarta.persistence.*;

@Entity
public class Auteur {

	@Id
	@Column(name = "id_auteur")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String nom;
	@ManyToMany
	@JoinTable(
		name="ecrire",
		joinColumns = @JoinColumn(name="id_auteur"),
		inverseJoinColumns = @JoinColumn(name = "id_ouvrage")
	)
	@JsonIgnoreProperties
	@JsonManagedReference(value="ouvrage-auteur")
	private List<Ouvrage> ouvrages;
	
	
	public Auteur(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Auteur() {

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
	public int hashCode() {
		return Objects.hash(id, nom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auteur other = (Auteur) obj;
		return Objects.equals(id, other.id) && Objects.equals(nom, other.nom);
	}


	public Auteur(Integer id, String nom, List<Ouvrage> ouvrages) {
		this.id = id;
		this.nom = nom;
		this.ouvrages = ouvrages;
	}

	@Override
	public String toString() {
		return "Auteur{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", ouvrages=" + ouvrages +
				'}';
	}
}
