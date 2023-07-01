package edu.datascientest.library_project.utilisateur;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public void addUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        utilisateurService.addUtilisateur(utilisateur);
    }


    @PostMapping("/login")
    public boolean login(@RequestBody @Valid LoginRequest loginRequest) {

        Utilisateur utilisateur = new Utilisateur(loginRequest.getLogin(), loginRequest.getMot_de_passe());
        return utilisateurService.login(utilisateur.getLogin(), utilisateur.getMot_de_passe());
    }

    @PostMapping("/signup")
    public boolean signup(@RequestBody @Valid Utilisateur utilisateur) {
        return utilisateurService.signup(utilisateur);
    }


    @GetMapping
    public List<Utilisateur> getUtilisateurs(Integer id) {
        return utilisateurService.getUtilisateurs();
    }

    @GetMapping("{id}")
    public Utilisateur getUtilisateur(@PathVariable("id") Integer id) {
        return utilisateurService.getUtilisateur(id);
    }

    @PutMapping
    public void updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.updateUtilisateur(utilisateur);
    }

    @DeleteMapping("{id}")
    public void deleteUtilisateur(@PathVariable("id") Integer id) {
        utilisateurService.deleteUtilisateur(id);
    }
}
