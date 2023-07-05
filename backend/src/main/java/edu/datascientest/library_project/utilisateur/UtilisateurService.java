package edu.datascientest.library_project.utilisateur;

import edu.datascientest.library_project.abonne.Abonne;
import edu.datascientest.library_project.abonne.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private AbonneService abonneService;

    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateur(Integer id) {
        return utilisateurRepository.findById(id).get();
    }

    public void updateUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }


    public List<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();

    }


    public boolean login(String login, String password) {
        Utilisateur utilisateurInput = new Utilisateur(login, password);
        Utilisateur utilisateurToCompareWith = utilisateurRepository.findByLogin(login);

        if (utilisateurToCompareWith == null) {
            return false;
        }


        return utilisateurInput.getLogin().equals(utilisateurToCompareWith.getLogin()) &&
                utilisateurInput.getMot_de_passe().equals(utilisateurToCompareWith.getMot_de_passe());
    }


    public boolean signup(Utilisateur utilisateur) {
        Utilisateur utilisateurToCompareWith = utilisateurRepository.findByLogin(utilisateur.getLogin());

        if (utilisateurToCompareWith == null) {
            utilisateurRepository.save(utilisateur);

            Abonne abonneInit = new Abonne();
            abonneInit.setUtilisateur(utilisateur);

            abonneService.addAbonne(abonneInit);
            return true;
        }

        return false;
    }


    public boolean isLibrarian(Utilisateur utilisateur) {
        return utilisateurRepository.findByLogin(utilisateur.getLogin()).isBibliothecaire();
    }

}
