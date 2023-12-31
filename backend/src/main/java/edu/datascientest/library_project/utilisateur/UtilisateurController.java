package edu.datascientest.library_project.utilisateur;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public void addUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        utilisateurService.addUtilisateur(utilisateur);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        Utilisateur utilisateur = new Utilisateur(loginRequest.getLogin(), loginRequest.getMot_de_passe());

        boolean isLibrarian = false;

        boolean isLoginSuccessful = utilisateurService.login(utilisateur.getLogin(), utilisateur.getMot_de_passe());

        if (isLoginSuccessful) {
            isLibrarian = utilisateurService.isLibrarian(utilisateur);
        }

        LoginResponse response = new LoginResponse(isLoginSuccessful, isLibrarian);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/signup")
    public boolean signup(@RequestBody @Valid Utilisateur utilisateur) {
        return utilisateurService.signup(utilisateur);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}")
    public Utilisateur getUtilisateur(@PathVariable("id") Integer id) {
        return utilisateurService.getUtilisateur(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public void updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.updateUtilisateur(utilisateur);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("{id}")
    public void deleteUtilisateur(@PathVariable("id") Integer id) {
        utilisateurService.deleteUtilisateur(id);
    }
}
