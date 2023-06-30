package edu.datascientest.library_project.type_ouvrage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class TypeOuvrageService {

    private TypeOuvrageRepository repository;

    @Autowired
    public TypeOuvrageService(TypeOuvrageRepository repository) {
        this.repository = repository;
    }

    //creer
    public void save(TypeOuvrage typeOuvrage){
        repository.save(typeOuvrage);
    }

    //modifier
    public void update(TypeOuvrage typeOuvrage){
        repository.save(typeOuvrage);
    }

    //lire list
    public List<TypeOuvrage> findAll(){
        return repository.findAll();
    }

    //trouver par id
    public TypeOuvrage findById(Integer id){
        return repository.findById(id).get();
    }

    //trouver par nom de type
    public TypeOuvrage findByType(String type){
        return (TypeOuvrage) repository.findByType(type);
    }

    //supprimer
    public void delete(Integer id){
        Optional<TypeOuvrage> type = repository.findById(id);
        if(!type.isEmpty()) {
            repository.delete(type.get());
        }
    }


}
