package edu.datascientest.library_project.ouvrage;

import java.util.List;
import java.util.Objects;

import edu.datascientest.library_project.auteur.Auteur;
import edu.datascientest.library_project.type_ouvrage.TypeOuvrage;
import jakarta.persistence.*;

@Entity
@Table(name="ouvrage")
public class Ouvrage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id_ouvrage;
	private String titre;
	private String auteur;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_type")
	private TypeOuvrage typeOuvrage;

	@ManyToMany
	@JoinTable(
			name="ecrire",
			joinColumns = @JoinColumn(name = "id_ouvrage"),
			inverseJoinColumns = @JoinColumn(name="id_auteur")
	)
	private List<Auteur> auteurs;

	public Ouvrage() {

	}

	public Ouvrage(Integer id_ouvrage, String titre, String auteur, TypeOuvrage typeOuvrage) {
		this.id_ouvrage = id_ouvrage;
		this.titre = titre;
		this.auteur = auteur;
		this.typeOuvrage = typeOuvrage;
	}

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



	public TypeOuvrage getTypeOuvrage() {
		return typeOuvrage;
	}

	public void setTypeOuvrage(TypeOuvrage typeOuvrage) {
		this.typeOuvrage = typeOuvrage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ouvrage ouvrage = (Ouvrage) o;
		return Objects.equals(getId_ouvrage(), ouvrage.getId_ouvrage()) && Objects.equals(getTitre(), ouvrage.getTitre()) && Objects.equals(getAuteur(), ouvrage.getAuteur()) && Objects.equals(getTypeOuvrage(), ouvrage.getTypeOuvrage());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId_ouvrage(), getTitre(), getAuteur(), getTypeOuvrage());
	}

	@Override
	public String toString() {
		return "Ouvrage{" +
				"id_ouvrage=" + id_ouvrage +
				", titre='" + titre + '\'' +
				", auteur='" + auteur + '\'' +
				", typeOuvrage=" + typeOuvrage +
				'}';
	}
}
