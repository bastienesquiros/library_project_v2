package edu.datascientest.library_project.ouvrage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ouvrage")
public class OuvrageController {

    private OuvrageService service;
    @Autowired
    public OuvrageController(OuvrageService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ouvrage> getListOuvrage(){
        return service.findAll();
    }

    //find by id
    @GetMapping("/findById")
    public Ouvrage findOuvrageById(Integer id){
        return service.findById(id);
    }

    //creer
    @PostMapping
    public void addOuvrage(@RequestBody Ouvrage ouvrage){
        service.save(ouvrage);
    }


    //modifier
    @PostMapping("/update")
    public void updateOuvrage(@RequestBody Ouvrage ouvrage){
        service.save(ouvrage);
    }


    //supprimer
    @DeleteMapping("/delete/{id}")
    public void deleteOuvrage(@PathVariable("id") Integer id){
        service.delete(id);
    }


}
