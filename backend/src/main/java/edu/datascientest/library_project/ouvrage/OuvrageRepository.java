package edu.datascientest.library_project.ouvrage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer> {

}
