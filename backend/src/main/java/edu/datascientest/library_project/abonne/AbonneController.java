package edu.datascientest.library_project.abonne;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonne")
public class AbonneController {
    @Autowired
    private AbonneService abonneService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Abonne> getAbonnes() {

        return abonneService.getAbonnes();
    }


    @GetMapping("{id}")
    public Abonne getAbonne(@PathVariable("id") Integer id) {
        return abonneService.getAbonne(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{idAbonne}/reserver/{idOuvrage}")
    public void reserveOuvrage(@PathVariable Integer idAbonne, @PathVariable Integer idOuvrage) {
        abonneService.reserveOuvrage(idAbonne, idOuvrage);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("{id}")
    public void deleteAbonne(@PathVariable("id") Integer id) {
        abonneService.deleteAbonne(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public void updateAbonne(@RequestBody Abonne abonne) {
        abonneService.updateAbonne(abonne);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public void addAbonne(@Valid @RequestBody Abonne abonne) {
        abonneService.addAbonne(abonne);
    }

}
