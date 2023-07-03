package edu.datascientest.library_project.ouvrage;

import edu.datascientest.library_project.auteur.Auteur;
import edu.datascientest.library_project.auteur.AuteurService;
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
    AuteurService auteurService;

    @Autowired
    public OuvrageServiceTest(OuvrageService ouvrageService, TypeOuvrageService typeOuvrageService, AuteurService auteurService) {
        this.ouvrageService = ouvrageService;
        this.typeOuvrageService = typeOuvrageService;
        this.auteurService = auteurService;
    }

    @Test
    void save() {
        TypeOuvrage typeOuvrage = new TypeOuvrage(88, "essaie");
        typeOuvrageService.save(typeOuvrage);

        Auteur auteur1 = new Auteur(77, "Crichton");
        auteurService.save(auteur1);
        Auteur auteur2 = new Auteur(78, "Michael");
        auteurService.save(auteur2);

        System.out.println("------------***------------");


        Ouvrage ouvrage = new Ouvrage("Jurassic Park 2030", typeOuvrage, auteur1, auteur2);
        System.out.println("ouvrage = " + ouvrage);
        ouvrageService.save(ouvrage);


        System.out.println("---------------------------");



        Ouvrage foundOuvrage = ouvrageService.findById(ouvrage.getId_ouvrage());
        System.out.println("foundOuvrage = " + foundOuvrage);
        Assertions.assertThat(foundOuvrage.getId_ouvrage()).isEqualTo(ouvrage.getId_ouvrage());
    }
}