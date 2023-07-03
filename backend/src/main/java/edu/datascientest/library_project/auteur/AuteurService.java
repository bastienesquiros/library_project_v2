package edu.datascientest.library_project.auteur;

import edu.datascientest.library_project.ouvrage.Ouvrage;
import edu.datascientest.library_project.ouvrage.OuvrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurService {


    @Autowired
    AuteurRepository auteurrepository;

    @Autowired
    OuvrageRepository ouvrageRepository;

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

    public List<Auteur> findAll() {
        return auteurrepository.findAll();
    }

    public void ecrit(Integer id_auteur, Integer id_ouvrage) {
        Auteur auteur = auteurrepository.findById(id_auteur).get();
        Ouvrage ouvrage = ouvrageRepository.findById(id_ouvrage).get();

        if (auteur != null && ouvrage != null) {
            auteur.getOuvrages().add(ouvrage);
            auteurrepository.save(auteur);
        }
    }
}
