package edu.datascientest.library_project.auteur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepository extends JpaRepository<Auteur, Integer> {

    Auteur findByNom(String nom);
}
