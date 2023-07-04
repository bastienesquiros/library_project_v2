package edu.datascientest.library_project.exemplaire;

import edu.datascientest.library_project.ouvrage.Ouvrage;
import edu.datascientest.library_project.ouvrage.OuvrageService;
import edu.datascientest.library_project.type_ouvrage.TypeOuvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/exemplaire")
public class ExemplaireController {
    private ExemplaireService service;
    private OuvrageService ouvrageService;

    @Autowired
    public ExemplaireController(ExemplaireService service, OuvrageService ouvrageService) {
        this.service = service;
        this.ouvrageService = ouvrageService;
    }

    //list Exemplaire
    @GetMapping
    public List<Exemplaire> getExemplaires() {
        return service.findAll();
    }

//    @GetMapping
//    public List<ExemplaireDto> getExemplaires() {
//        List<ExemplaireDto> listDto = new ArrayList<>();
//        List<Exemplaire> all = service.findAll();
//        for(Exemplaire ex : all){
//            ExemplaireDto dto = new ExemplaireDto();
//            dto.setId_exemplaire(ex.getId_exemplaire());
//            dto.setEtat(ex.getEtat());
//            Ouvrage ouvrage = ouvrageService.findById(ex.getId_exemplaire());
//            dto.setNomOuvrage(ouvrage.getTitre());
//        }
//        System.out.println(listDto);
//        return listDto;
//    }

    //Find by id
    @GetMapping("/findById")
    public Exemplaire findExemplaireById(@RequestParam("id") Integer id){
        return service.findById(id);
    }

    //créer
    @PostMapping
    public void addExemplaire(@RequestBody Exemplaire exemplaire){
        service.save(exemplaire);
    }


    //modifier
    @PostMapping("/update")
    public void updateExemplaire(@RequestBody  Exemplaire exemplaire){
        service.save(exemplaire);
    }


    //supprimer
    @DeleteMapping("/delete/{id}")
    public void deleteExemplaire(@PathVariable("id") Integer id){
        service.delete(id);
    }


}
