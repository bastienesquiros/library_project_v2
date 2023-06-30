package edu.datascientest.library_project.type_ouvrage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public interface TypeOuvrageRepository extends JpaRepository<TypeOuvrage, Integer> {
    List<TypeOuvrage> findByType(String typeOuvrage);
}
