package edu.datascientest.library_project.auteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auteur")
public class AuteurController {

    @Autowired
    AuteurService auteurservice;

    @GetMapping
    public List<Auteur> getAuteurs() {
        return auteurservice.findAll();
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
    public Auteur getAuteurById(@RequestParam(name = "id") Integer id) {
        return auteurservice.findById(id);
    }

    @PostMapping("{id_auteur}/ecrit/{id_ouvrage}")
    public void ecrit(@PathVariable("id_auteur") Integer id_auteur, @PathVariable("id_ouvrage") Integer id_ouvrage) {
        auteurservice.ecrit(id_auteur, id_ouvrage);
    }

}
