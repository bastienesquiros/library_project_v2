import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

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
  bibliothequaire: boolean = false;


  constructor(private http: HttpClient) {
  }

  onSubmit(): void {
    const signupRequest = {
      prenom: this.prenom,
      nom: this.nom,
      adresse: this.adresse,
      login: this.login,
      mot_de_passe: this.mot_de_passe,
      bibliothequaire: this.bibliothequaire
    }
    this.http.post('http://localhost:8080/utilisateur/signup', signupRequest).subscribe(
      (response: any) => {
        console.log(response);

        if (response == true) {
          console.log("REDIRECTION VERS LA PAGE D'ACCUEIL SELON LE ROLE ! (CHECK POUR LIBRAIRE OU PAS)");
        } else {
          console.log("utilisateur déjà existant ou bien erreur saisi, INFORMER UTILISATEUR ");
        } // gérer autres cas erreurs, check la console chrome

      });
  }
}
