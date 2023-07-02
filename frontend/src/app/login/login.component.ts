import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';


  constructor(private http: HttpClient) {
  }


  onSubmit(): void {
    const loginRequest = {
      login: this.username,
      mot_de_passe: this.password
    };
    this.http.post('http://localhost:8080/utilisateur/login', loginRequest).subscribe(
      (response: any) => {
        console.log(response);


        if (response.loginSuccessful == true) {
          console.log("REDIRECTION VERS LA PAGE D'ACCUEIL SELON LE ROLE ! (CHECK POUR LIBRAIRE OU PAS)");
        } else {
          console.log("Mauvais login ou mot de passe, INFORMER UTILISATEUR ");
        }

      }
    );
  }
}
