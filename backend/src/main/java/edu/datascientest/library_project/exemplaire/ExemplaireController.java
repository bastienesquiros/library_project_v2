package edu.datascientest.library_project.exemplaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplaire")
public class ExemplaireController {
    private ExemplaireService service;
    @Autowired
    public ExemplaireController(ExemplaireService service) {
        this.service = service;
    }



}
