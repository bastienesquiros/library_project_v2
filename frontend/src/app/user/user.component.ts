import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  id_user: number = 0;
  id_user_to_update: number = 0;
  thisUser: string = '';
  id_user_delete: number = 0;
  nom: string = '';
  prenom: string = '';
  adresse: string = '';
  login: string = '';
  mot_de_passe: string = '';
  bibliothecaire: boolean = false;
  nomToUpdate: string = '';
  prenomToUpdate: string = '';
  adresseToUpdate: string = '';
  loginToUpdate: string = '';
  mot_de_passeToUpdate: string = '';
  bibliothecaireToUpdate: boolean = false;
  usersIdT: string = '';

  constructor(private http: HttpClient, private router: Router) {
  }

  GetUserById() : void {
    this.http.get("http://localhost:8080/utilisateur/" + this.id_user).subscribe (
      (response: any) => {
        if (response) {
          console.log("l'utilisateur recherché est : ", response.login );
          this.thisUser = response.login;
        }
      }
    )
  }

  DeleteUserById() : void {
    this.http.delete("http://localhost:8080/utilisateur/" + this.id_user_delete).subscribe (
      (response: any) => {
        if (response) {
          console.log("l'utilisateur supprimé est : ", response.login );
        }
      }
    )
  }

  PostUser() : void {
    const userRequest = {
      nom: this.nom,
      prenom: this.prenom,
      adresse: this.adresse,
      login: this.login,
      mot_de_passe: this.mot_de_passe,
      bibliothecaire: this.bibliothecaire
    };

    this.http.post("http://localhost:8080/utilisateur/signup", userRequest).subscribe (
      (response: any) => {
        if (response) {
          console.log("l'utilisateur : ", this.login, "as était ajouté" );
        } else {
          console.log("l'utilisateur : ", this.login, "n'as pas était ajouté" );
        }
      }
    )
  }

  UpdateUser() : void {
    const updateUserRequest = {
      id_utilisateur: this.id_user_to_update,
      nom: this.nomToUpdate,
      prenom: this.prenomToUpdate,
      adresse: this.adresseToUpdate,
      login: this.loginToUpdate,
      mot_de_passe: this.mot_de_passeToUpdate,
      bibliothecaire: this.bibliothecaireToUpdate
    };

    this.http.put("http://localhost:8080/utilisateur", updateUserRequest).subscribe (
      (response: any) => {
        if (response) {
          console.log("l'utilisateur : ", this.loginToUpdate, "a était modifié" );
        }
      }
    )
  }

  GetUsers() : void {
    this.http.get("http://localhost:8080/utilisateur").subscribe (
      (response: any) => {
        if (response) {
          console.log(response);
          response.filter((e: any) => console.log(e))
          response.forEach((e: any) => {
            this.usersIdT +=  e.login += " / ";
          });
        }
      }
    )
  }
}
