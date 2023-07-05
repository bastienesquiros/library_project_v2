package edu.datascientest.library_project.ouvrage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<OuvrageDto> getListOuvrageDto(){
        List<Ouvrage> listOuvrage = service.findAll();
        List<OuvrageDto> listDto = new ArrayList<>();
        for(Ouvrage o : listOuvrage){
            listDto.add(OuvrageDto.convertToDto(o));
        }
        return listDto;
    }

    //find by id
    @GetMapping("/findById")
    public OuvrageDto findOuvrageById(Integer id){
        Ouvrage ouvrage = service.findById(id);
        OuvrageDto dto = OuvrageDto.convertToDto(ouvrage);
        return dto;
    }

    //find by titre
    @GetMapping("/findByTitre")
    public OuvrageDto findOuvrageByTitre(@RequestParam(name="titre") String titre){
        Ouvrage ouvrage = service.findByTitre(titre);
        return OuvrageDto.convertToDto(ouvrage);
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
