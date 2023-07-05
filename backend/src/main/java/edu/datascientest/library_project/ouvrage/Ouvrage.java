package edu.datascientest.library_project.ouvrage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.datascientest.library_project.abonne.Abonne;
import edu.datascientest.library_project.auteur.Auteur;
import edu.datascientest.library_project.exemplaire.Exemplaire;
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

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_type")
	@JsonBackReference
	private TypeOuvrage typeOuvrage;

	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinTable(
		name="ecrire",
		joinColumns = @JoinColumn(name = "id_ouvrage"),
		inverseJoinColumns = @JoinColumn(name="id_auteur")
	)
	private List<Auteur> auteurs;

	@ManyToMany(fetch = FetchType.EAGER) @JsonIgnore
	@JoinTable(
		name = "reserve",
		joinColumns = @JoinColumn(name = "id_ouvrage"),
		inverseJoinColumns = @JoinColumn(name = "id_abonne")
		)
	private List<Abonne> abonnes;

	@OneToMany(mappedBy="ouvrage", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference @JsonIgnore
	private List<Exemplaire> exemplaires;

	public Ouvrage() {	}

	public Ouvrage(String titre, TypeOuvrage typeOuvrage, Auteur... auteurs) {
		this.titre = titre;
		this.typeOuvrage = typeOuvrage;
		if(this.auteurs == null) this.auteurs = new ArrayList<>();
		this.auteurs.addAll(Arrays.stream(auteurs).toList());
	}

	public Ouvrage(Integer id_ouvrage, String titre, TypeOuvrage typeOuvrage, List<Auteur> auteurs, List<Abonne> abonnes, List<Exemplaire> exemplaires) {
		this.id_ouvrage = id_ouvrage;
		this.titre = titre;
		this.typeOuvrage = typeOuvrage;
		this.auteurs = auteurs;
		this.abonnes = abonnes;
		this.exemplaires = exemplaires;
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
	public TypeOuvrage getTypeOuvrage() {
		return typeOuvrage;
	}
	public void setTypeOuvrage(TypeOuvrage typeOuvrage) {
		this.typeOuvrage = typeOuvrage;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	public List<Abonne> getAbonnes() {
		return abonnes;
	}

	public void setAbonnes(List<Abonne> abonnes) {
		this.abonnes = abonnes;
	}

	@Override
	public String toString() {
		return "Ouvrage{" +
				"id_ouvrage=" + id_ouvrage +
				", titre='" + titre + '\'' +
				", typeOuvrage=" + typeOuvrage +
				", auteurs=" + auteurs +
				", abonnes=" + abonnes +
				", exemplaires=" + exemplaires +
				'}';
	}
}
