package edu.datascientest.library_project.utilisateur;

public class LoginRequest {
    private String login;
    private String mot_de_passe;

    public LoginRequest(String login, String mot_de_passe) {
        this.login = login;
        this.mot_de_passe = mot_de_passe;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
