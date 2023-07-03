package edu.datascientest.library_project.ouvrage;

import edu.datascientest.library_project.type_ouvrage.TypeOuvrage;
import edu.datascientest.library_project.type_ouvrage.TypeOuvrageRepository;
import edu.datascientest.library_project.type_ouvrage.TypeOuvrageService;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class OuvrageServiceTest {

    OuvrageService ouvrageService;
    TypeOuvrageService typeOuvrageService;
    @Autowired
    private TypeOuvrageRepository typeOuvrageRepository;

    @Autowired
    public OuvrageServiceTest(OuvrageService ouvrageService, TypeOuvrageService typeOuvrageService) {
        this.ouvrageService = ouvrageService;
        this.typeOuvrageService = typeOuvrageService;
    }


    @Test
    void save() {
        TypeOuvrage typeOuvrage = new TypeOuvrage(88, "essaie");
        typeOuvrageService.save(typeOuvrage);
        Ouvrage ouvrage = new Ouvrage(99, "nine", "P", typeOuvrage);
        ouvrageService.save(ouvrage);


        System.out.println("---------------------------");

        Ouvrage foundOuvrage = ouvrageService.findById(99);
        System.out.println("foundOuvrage = " + foundOuvrage);
        Assertions.assertThat(foundOuvrage.getId_ouvrage()).isEqualTo(99);
    }
}