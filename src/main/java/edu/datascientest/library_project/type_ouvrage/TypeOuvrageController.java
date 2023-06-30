package edu.datascientest.library_project.type_ouvrage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("/type_ouvrage")
public class TypeOuvrageController {

    private TypeOuvrageService service;

    @Autowired
    public TypeOuvrageController(TypeOuvrageService service) {
        this.service = service;
    }

    //list type
    @GetMapping
    public List<TypeOuvrage> getTypeOuvrageList(){
        return service.findAll();
    }

    //find by id
    @GetMapping("/findById")
    public TypeOuvrage findTypeById(@RequestParam("id") Integer id){
        return service.findById(id);
    }

    //find by le nom de type
//    @GetMapping("/findByType")
//    public TypeOuvrage findTypeByType(@RequestParam("type") String type){
//        return service.findByType(type);
//    }

    //creer
    @PostMapping
    public void addTypeOuvrage(@RequestBody TypeOuvrage typeOuvrage){
        service.save(typeOuvrage);
    }


    //modifier
    @PostMapping("/update")
    public void updateClient(@RequestBody TypeOuvrage typeOuvrage){
        service.save(typeOuvrage);
    }


    //supprimer
    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") Integer id){
        service.delete(id);
    }


}
