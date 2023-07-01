package edu.datascientest.library_project.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByLogin(String login);


}
