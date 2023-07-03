package edu.datascientest.library_project.exemplaire;

import edu.datascientest.library_project.type_ouvrage.TypeOuvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExemplaireService {
    private ExemplaireRepository repository;
    @Autowired
    public ExemplaireService(ExemplaireRepository repository) {
        this.repository = repository;
    }

    //consulter la liste d'exemplaires
    public List<Exemplaire> findAll(){
        return repository.findAll();
    }

    //trouver par id
    public Exemplaire findById(Integer id){
        return repository.findById(id).get();
    }

    //creer
    public void save(Exemplaire exemplaire){
        repository.save(exemplaire);
    }

    //modifier
    public void update(Exemplaire exemplaire){
        repository.save(exemplaire);
    }

    //supprimer
    public void delete(Integer id){
        Optional<Exemplaire> type = repository.findById(id);
        if(!type.isEmpty()) {
            repository.delete(type.get());
        }
    }





}
