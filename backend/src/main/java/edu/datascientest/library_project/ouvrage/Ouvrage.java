package edu.datascientest.library_project.ouvrage;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ouvrage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_ouvrage;
	private String titre;
	private String auteur;
	private Integer id_type;
	public Integer getId_ouvrage() {
		return id_ouvrage;
	}
	public void setId_ouvrage(Integer id_ouvrage) {
		this.id_ouvrage = id_ouvrage;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Integer getId_type() {
		return id_type;
	}
	public void setId_type(Integer id_type) {
		this.id_type = id_type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(auteur, id_ouvrage, id_type, titre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvrage other = (Ouvrage) obj;
		return Objects.equals(auteur, other.auteur) && Objects.equals(id_ouvrage, other.id_ouvrage)
				&& Objects.equals(id_type, other.id_type) && Objects.equals(titre, other.titre);
	}
	@Override
	public String toString() {
		return "Ouvrage [id_ouvrage=" + id_ouvrage + ", titre=" + titre + ", auteur=" + auteur + ", id_type=" + id_type
				+ "]";
	}

	
}
