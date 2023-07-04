package edu.datascientest.library_project.emprunt;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emprunt")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @PostMapping
    public void addEmprunt(@RequestBody @Valid Emprunt emprunt) {
        //System.out.println(emprunt.getId_abonne() + "TESST");
        empruntService.addEmprunt(emprunt);
    }

    @PutMapping
    public void updateEmprunt(@RequestBody @Valid Emprunt emprunt) {
        empruntService.updateEmprunt(emprunt);
    }

    @DeleteMapping("{id}")
    public void deleteEmprunt(@PathVariable("id") Integer id) {
        empruntService.deleteEmprunt(id);
    }

    @GetMapping("{id}")
    public EmpruntDto getEmprunt(@PathVariable("id") Integer id) {
        return EmpruntDto.convertToDto(empruntService.getEmprunt(id));
    }

    @GetMapping
    public List<EmpruntDto> getEmprunts() {
        List<Emprunt> listEmprunt = empruntService.getEmprunts();
        List<EmpruntDto> listDto = new ArrayList<>();
        for(Emprunt e : listEmprunt){
            listDto.add(EmpruntDto.convertToDto(e));
        }
        return listDto;
    }


}
