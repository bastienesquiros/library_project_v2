package edu.datascientest.library_project.type_ouvrage;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TypeOuvrageServiceTest {



    TypeOuvrageService service;
    @Autowired
    public TypeOuvrageServiceTest(TypeOuvrageService service) {
        this.service = service;
    }


    @Test
    void findByType() {
        TypeOuvrage typeOuvrage = new TypeOuvrage();
        typeOuvrage.setType("abc");
        service.save(typeOuvrage);

        TypeOuvrage foundType = service.findById(typeOuvrage.getId());
        Assertions.assertThat(foundType.getType().equals("abc"));
        System.out.println("le nom de type trouvé : "+foundType.getType().toString());
    }
}