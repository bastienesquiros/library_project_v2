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
    public List<ExemplaireDto> getExemplaires() {
        List<Exemplaire> listExemplaire = service.findAll();
        List<ExemplaireDto> listDto = new ArrayList<>();
        for(Exemplaire e : listExemplaire){
            listDto.add(ExemplaireDto.convertToDto(e));
        }
        return listDto;
    }


    //Find by id
    @GetMapping("/findById")
    public ExemplaireDto findExemplaireById(@RequestParam("id") Integer id){
        return ExemplaireDto.convertToDto(service.findById(id));
    }

    //créer
    @PostMapping
    public void addExemplaire(@RequestBody Exemplaire exemplaire){
        service.save(exemplaire);
    }


    //modifier
    @PutMapping("/update")
    public void updateExemplaire(@RequestBody  Exemplaire exemplaire){
        service.save(exemplaire);
    }


    //supprimer
    @DeleteMapping("/delete/{id}")
    public void deleteExemplaire(@PathVariable("id") Integer id){
        service.delete(id);
    }


}
