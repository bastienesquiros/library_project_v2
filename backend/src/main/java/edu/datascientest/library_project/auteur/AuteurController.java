package edu.datascientest.library_project.auteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auteur")
public class AuteurController {

    @Autowired
    AuteurService auteurservice;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<AuteurDto> getAuteurs() {
        List<Auteur> auteurs = auteurservice.findAll();
        List<AuteurDto> auteurDtos = new ArrayList<>();
        for(Auteur a : auteurs){
            auteurDtos.add(AuteurDto.convertToDto(a));
        }
        return auteurDtos;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuteur(@RequestBody Auteur auteur) {
        auteurservice.save(auteur);
    }

    @DeleteMapping("{id}")
    public void deleteAuteur(@PathVariable("id") Integer id) {
        auteurservice.delete(id);
    }

    @PutMapping
    public void updateAuteur(@RequestBody Auteur auteur) {
        auteurservice.update(auteur);
    }

    @GetMapping("auteur")
    public AuteurDto getAuteurById(@RequestParam(name = "id") Integer id) {
        return AuteurDto.convertToDto(auteurservice.findById(id));
    }

    @PostMapping("{id_auteur}/ecrit/{id_ouvrage}")
    public void ecrit(@PathVariable("id_auteur") Integer id_auteur, @PathVariable("id_ouvrage") Integer id_ouvrage) {
        auteurservice.ecrit(id_auteur, id_ouvrage);
    }

    //find by nom d'auteur
    @GetMapping("auteur_nom")
    public AuteurDto getAuteurByNom(@RequestParam(name="nom") String nom){
        Auteur auteur = auteurservice.findByNom(nom);
        return AuteurDto.convertToDto(auteur);
    }

}
