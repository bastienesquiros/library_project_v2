package edu.datascientest.library_project.emprunt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EmpruntService {
    @Autowired
    private EmpruntRepository empruntRepository;

    public void addEmprunt(Emprunt emprunt) {

//        emprunt.setDate_debut_emprunt(Date.valueOf(java.time.LocalDate.now()));
//        emprunt.setDate_fin_emprunt_attendue(Date.valueOf(java.time.LocalDate.now().plusDays(5)));
        empruntRepository.save(emprunt);
    }

    public void updateEmprunt(Emprunt emprunt) {
        empruntRepository.save(emprunt);
    }

    public void deleteEmprunt(Integer id) {
        empruntRepository.deleteById(id);
    }

    public Emprunt getEmprunt(Integer id) {
        return empruntRepository.findById(id).get();
    }

    public List<Emprunt> getEmprunts() {
        return empruntRepository.findAll();
    }
}
