package edu.datascientest.library_project.auteur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuteurService {
	
	
	 @Autowired
	AuteurRepository auteurrepository;

	// méthode pour sauvegarder un auteur
	 
	public void save(Auteur auteur) {
		auteurrepository.save(auteur);
	}
	
	// méthode pour supprimer un auteur
	
	public void delete(Integer id) {
		auteurrepository.deleteById(id);
	}
	
	// méthode pour modifier un auteur
	
	public void update(Auteur auteur) {
		auteurrepository.save(auteur);
	}
	
	// méthode pour lire un auteur par id
	
	public Auteur findById(Integer id) {
		return auteurrepository.findById(id).get();
	}

	// méthode pour lire tous les auteurs
	
	public List<Auteur> findAll(){
		return auteurrepository.findAll();
	}
	 

}
