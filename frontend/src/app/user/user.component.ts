import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

interface User {
  id_utilisateur: number;
  nom: string;
  prenom: string;
  adresse: string;
  login: string;
  mot_de_passe: string;
  bibliothecaire: boolean;
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  public user: User[] = []

  searchText: string = '';
  filteredUser: any[] = [];

  newUser: User = {
    id_utilisateur: 0,
    nom: '',
    prenom: '',
    adresse: '',
    login: '',
    mot_de_passe: '',
    bibliothecaire: false
  }

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllUser();
  };

  getAllUser() : void {
    this.http.get<User[]>("http://localhost:8080/utilisateur").subscribe (
      (response: User[]) => {
        this.user = response;
        console.log(this.user);
        this.filterUser();
      }
    )
  }

  filterUser() : void {
    if (this.searchText.trim() === '') {
      // If search text is empty, show all abonnes
      this.filteredUser = this.user;
    } else {
      // Filter auteurs based on search text
      this.filteredUser = this.user.filter(user =>
        user.id_utilisateur.toString().includes(this.searchText.trim()) ||
        user.nom.toString().includes(this.searchText.trim()) ||
        user.prenom.toString().includes(this.searchText.trim()) ||
        user.adresse.toString().includes(this.searchText.trim()) ||
        user.login.toString().includes(this.searchText.trim()) ||
        user.mot_de_passe.toString().includes(this.searchText.trim()) ||
        user.bibliothecaire.toString().includes(this.searchText.trim())
      );
    }
  }

  DeleteUser(user: User) : void {
    this.http.delete('http://localhost:8080/utilisateur/' + user.id_utilisateur).subscribe(
      (response: any) => {
        if (response) {
          console.log("l'auteur supprimé est : ", response.nom );
          this.getAllUser();
        }
      }
    );
  }

  editUser(user: User): void {
    this.newUser = {...user}; // Set the form fields with the selected abonne data
  }

  submitForm(): void {
    if (this.newUser.id_utilisateur) {
      const requestPut = {
        id_utilisateur: this.newUser.id_utilisateur,
        nom: this.newUser.nom,
        prenom: this.newUser.prenom,
        adresse: this.newUser.adresse,
        login: this.newUser.login,
        mot_de_passe: this.newUser.mot_de_passe,
        bibliothecaire: this.newUser.bibliothecaire
      };

      this.http.put('http://localhost:8080/utilisateur', requestPut).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    } else {
      const requestPost = {
        id_utilisateur: this.newUser.id_utilisateur,
        nom: this.newUser.nom,
        prenom: this.newUser.prenom,
        adresse: this.newUser.adresse,
        login: this.newUser.login,
        mot_de_passe: this.newUser.mot_de_passe,
        bibliothecaire: this.newUser.bibliothecaire
      };

      this.http.post('http://localhost:8080/utilisateur/signup', requestPost).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    }
  }

  private handleFormSubmission(): void {
    this.getAllUser();
    this.resetFormFields();
  }

  private resetFormFields(): void {
    this.newUser = {
      id_utilisateur: 0,
      nom: '',
      prenom: '',
      adresse: '',
      login: '',
      mot_de_passe: '',
      bibliothecaire: false
    };
  }

  // GetUserById() : void {
  //   this.http.get("http://localhost:8080/utilisateur/" + this.id_utilisateur).subscribe (
  //     (response: any) => {
  //       if (response) {
  //         console.log("l'utilisateur recherché est : ", response.login );
  //         this.thisUser = response.login;
  //       }
  //     }
  //   )
  // }

  // DeleteUserById() : void {
  //   this.http.delete("http://localhost:8080/utilisateur/" + this.id_utilisateur_delete).subscribe (
  //     (response: any) => {
  //       if (response) {
  //         console.log("l'utilisateur supprimé est : ", response.login );
  //       }
  //     }
  //   )
  // }

  // PostUser() : void {
  //   const userRequest = {
  //     nom: this.nom,
  //     prenom: this.prenom,
  //     adresse: this.adresse,
  //     login: this.login,
  //     mot_de_passe: this.mot_de_passe,
  //     bibliothecaire: this.bibliothecaire
  //   };

  //   this.http.post("http://localhost:8080/utilisateur/signup", userRequest).subscribe (
  //     (response: any) => {
  //       if (response) {
  //         console.log("l'utilisateur : ", this.login, "as était ajouté" );
  //       } else {
  //         console.log("l'utilisateur : ", this.login, "n'as pas était ajouté" );
  //       }
  //     }
  //   )
  // }

  // UpdateUser() : void {
  //   const updateUserRequest = {
  //     id_utilisateur: this.id_utilisateur_to_update,
  //     nom: this.nomToUpdate,
  //     prenom: this.prenomToUpdate,
  //     adresse: this.adresseToUpdate,
  //     login: this.loginToUpdate,
  //     mot_de_passe: this.mot_de_passeToUpdate,
  //     bibliothecaire: this.bibliothecaireToUpdate
  //   };

  //   this.http.put("http://localhost:8080/utilisateur", updateUserRequest).subscribe (
  //     (response: any) => {
  //       if (response) {
  //         console.log("l'utilisateur : ", this.loginToUpdate, "a était modifié" );
  //       }
  //     }
  //   )
  // }

  // GetUsers() : void {
  //   this.http.get("http://localhost:8080/utilisateur").subscribe (
  //     (response: any) => {
  //       if (response) {
  //         console.log(response);
  //         response.filter((e: any) => console.log(e))
  //         response.forEach((e: any) => {
  //           this.usersIdT +=  e.login += " / ";
  //         });
  //       }
  //     }
  //   )
  // }
}
