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

    @GetMapping
    public List<Abonne> getAbonnes() {
        return abonneService.getAbonnes();
    }


    @GetMapping("{id}") //http://localhost:8080/abonne/2
    public Abonne getAbonne(@PathVariable("id") Integer id) {
        return abonneService.getAbonne(id);
    }

    @PostMapping("/{idAbonne}/reserver/{idOuvrage}")
    public void reserveOuvrage(@PathVariable Integer idAbonne, @PathVariable Integer idOuvrage) {
        abonneService.reserveOuvrage(idAbonne, idOuvrage);
    }

    @DeleteMapping("{id}")
    public void deleteAbonne(@PathVariable("id") Integer id) {
        abonneService.deleteAbonne(id);
    }

    @PutMapping
    public void updateAbonne(@RequestBody Abonne abonne) {
        abonneService.updateAbonne(abonne);
    }

    @PostMapping
    public void addAbonne(@Valid @RequestBody Abonne abonne) {
        abonneService.addAbonne(abonne);
    }

}
