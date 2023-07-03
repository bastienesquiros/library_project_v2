package edu.datascientest.library_project.auteur;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Auteur {

	@Id
	@Column(name = "id_auteur")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String nom;
	
	public Auteur() {
		
	}
	
	
	public Auteur(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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


	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	
}
