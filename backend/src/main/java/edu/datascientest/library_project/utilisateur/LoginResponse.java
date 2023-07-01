package edu.datascientest.library_project.utilisateur;

public class LoginResponse {


    private boolean isLoginSuccessful;
    private boolean isLibrarian;

    public LoginResponse(boolean isLoginSuccessful, boolean isLibrarian) {
        this.isLoginSuccessful = isLoginSuccessful;
        this.isLibrarian = isLibrarian;
    }

    public boolean isLoginSuccessful() {
        return isLoginSuccessful;
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        isLoginSuccessful = loginSuccessful;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }

    public void setLibrarian(boolean librarian) {
        isLibrarian = librarian;
    }
}
