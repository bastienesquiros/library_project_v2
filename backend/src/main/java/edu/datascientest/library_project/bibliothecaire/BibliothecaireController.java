package edu.datascientest.library_project.bibliothecaire;

import edu.datascientest.library_project.auteur.AuteurService;
import edu.datascientest.library_project.ouvrage.Ouvrage;
import edu.datascientest.library_project.ouvrage.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bibliothecaire")
public class BibliothecaireController {
    @Autowired
    OuvrageService ouvrageService;

    @Autowired
    AuteurService auteurService;

    @GetMapping
    public List<Ouvrage> getOuvrage() {
        return ouvrageService.findAll();
    }

    @GetMapping("ouvrage")
    public Ouvrage findById(@RequestParam(name = "id_ouvrage") Integer id_ouvrage) {
        return ouvrageService.findById(id_ouvrage);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postOuvrage(@RequestBody Ouvrage ouvrage) {
        ouvrageService.save(ouvrage);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClient(@RequestBody Ouvrage request) {
        ouvrageService.update(request);
    }

    @DeleteMapping("{id_ouvrage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOuvrage(@PathVariable("id_ouvrage") Integer id_ouvrage) {
        ouvrageService.delete(id_ouvrage);
    }


}
