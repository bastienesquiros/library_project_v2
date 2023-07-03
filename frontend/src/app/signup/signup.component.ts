import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {


  prenom: string = '';
  nom: string = '';
  adresse: string = '';
  login: string = '';
  mot_de_passe: string = '';
  bibliothecaire: boolean = false;
  errorMessage: string = '';

  constructor(private http: HttpClient, private router: Router) {
  }

  onSubmit(): void {
    const signupRequest = {
      prenom: this.prenom,
      nom: this.nom,
      adresse: this.adresse,
      login: this.login,
      mot_de_passe: this.mot_de_passe,
      bibliothecaire: this.bibliothecaire

    }

    this.http.post('http://localhost:8080/utilisateur/signup', signupRequest).subscribe(
      (response: any) => {


        if (response.loginSuccessful === true) {
          // User authenticated successfully
          if (response.librarian === true) {
            this.router.navigate(['/librarianside']);
          } else {
            this.router.navigate(['/subscriberside']);
          }
        } else {
          // Authentication failed
          this.errorMessage = "Vous êtes déjà inscrit";
        }


      });
  }
}
