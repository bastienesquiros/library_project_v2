package edu.datascientest.library_project.abonne;

import edu.datascientest.library_project.ouvrage.Ouvrage;
import edu.datascientest.library_project.ouvrage.OuvrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonneService {

    @Autowired
    private AbonneRepository abonneRepository;
    @Autowired
    private OuvrageRepository ouvrageRepository;


    public void addAbonne(Abonne abonne) {
        abonneRepository.save(abonne);
    }

    public void updateAbonne(Abonne abonne) {
        abonneRepository.save(abonne);
    }

    public void deleteAbonne(Integer id) {
        abonneRepository.deleteById(id);
    }

    public Abonne getAbonne(Integer id) {
        return abonneRepository.findById(id).get();
    }

    public List<Abonne> getAbonnes() {
        return abonneRepository.findAll();
    }

    public void reserveOuvrage(Integer idAbonne, Integer idOuvrage) {
        Abonne abonne = abonneRepository.findById(idAbonne).get();
        Ouvrage ouvrage = ouvrageRepository.findById(idOuvrage).get();

        if (abonne != null && ouvrage != null) {
            abonne.getOuvrages().add(ouvrage);
            abonneRepository.save(abonne);
        }
    }
}

