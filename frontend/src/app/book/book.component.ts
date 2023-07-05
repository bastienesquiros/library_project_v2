import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

interface Ouvrage {
  id_ouvrage: number;
  titre: string;
  auteurs: {
    id_auteur: number;
    nom: string;
  };
  typeOuvrage: {
    id_type: number;
    type: string;
  };
}

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {
  public ouvrage: Ouvrage[] = []

  searchText: string = '';
  filteredOuvrage: any[] = [];

  newOuvrage: Ouvrage = {
    id_ouvrage: 0,
    titre: '',
    auteurs: {
      id_auteur: 0,
      nom: ''
    },
    typeOuvrage: {
      id_type: 0,
      type: ''
    }
  }

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllOuvrage();
  };

  getAllOuvrage() : void {
    this.http.get<Ouvrage[]>("http://localhost:8080/bibliothecaire").subscribe (
      (response: Ouvrage[]) => {
        this.ouvrage = response;
        console.log(this.newOuvrage.auteurs.id_auteur, " + ", this.newOuvrage.auteurs.nom, " + ", this.newOuvrage.typeOuvrage.id_type, " + ", this.newOuvrage.typeOuvrage.type);
        this.filterOuvrage();
      }
    )
  }

  filterOuvrage() : void {
    if (this.searchText.trim() === '') {
      // If search text is empty, show all abonnes
      this.filteredOuvrage = this.ouvrage;
    } else {
      // Filter auteurs based on search text
      this.filteredOuvrage = this.ouvrage.filter(ouvrage =>
        ouvrage.id_ouvrage.toString().includes(this.searchText.trim()) ||
        ouvrage.titre.toString().includes(this.searchText.trim()) ||
        ouvrage.auteurs.id_auteur.toString().includes(this.searchText.trim()) ||
        ouvrage.typeOuvrage.id_type.toString().includes(this.searchText.trim())
      );
    }
  }

  DeleteOuvrage(ouvrage: Ouvrage) : void {
    this.http.delete('http://localhost:8080/bibliothecaire/' + ouvrage.id_ouvrage).subscribe(
      (response: any) => {
        if (response) {
          console.log("l'auteur supprimé est : ", response.nom );
          this.getAllOuvrage();
        }
      }
    );
  }

  editOuvrage(ouvrage: Ouvrage): void {
    this.newOuvrage = {...ouvrage}; // Set the form fields with the selected abonne data
  }

  submitForm(): void {
    if (this.newOuvrage.id_ouvrage) {
      const requestPut = {
        id: this.newOuvrage.id_ouvrage,
        titre: this.newOuvrage.titre,
        id_auteur: this.newOuvrage.auteurs.id_auteur,
        id_type: this.newOuvrage.typeOuvrage.id_type
      };

      this.http.put('http://localhost:8080/bibliothecaire', requestPut).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    } else {
      const requestPost = {
        id: this.newOuvrage.id_ouvrage,
        titre: this.newOuvrage.titre,
        id_auteur: this.newOuvrage.auteurs.id_auteur,
        id_type: this.newOuvrage.typeOuvrage.id_type
      };

      this.http.post('http://localhost:8080/bibliothecaire', requestPost).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    }
  }

  private handleFormSubmission(): void {
    this.getAllOuvrage();
    this.resetFormFields();
  }

  private resetFormFields(): void {
    this.newOuvrage = {
      id_ouvrage: 0,
      titre: '',
      auteurs: {
        id_auteur: 0,
        nom: ''
      },
      typeOuvrage: {
        id_type: 0,
        type: ''
      }
    };
  }

  // PostBook(): void {
  //   const bookRequest = {
  //     titre: this.titre,
  //     id_auteur: this.id_auteur,
  //     id_type: this.id_type
  //   };
    
  //   this.http.post('http://localhost:8080/bibliothecaire', bookRequest).subscribe(
  //     (response: any) => {
  //       if (response) {
  //         console.log('le livre : ', this.titre, ' a était ajouté');
  //       } else {
  //         this.errorMessage = "Erreur dans la saisie";
  //       }
  //     }
  //   );
  // }

  // GetBookById(): void {
  //   this.http.get('http://localhost:8080/bibliothecaire/ouvrage?id=' + this.id).subscribe(
  //     (response: any) => {
  //       if (response) {
  //         console.log('le livre recherché est : ', response.titre );
  //         this.bookById = response.titre;
  //       } else {
  //         this.errorMessageGetById = "Erreur dans la saisie";
  //       }
  //     }
  //   );
  // }

  // DeleteBook(): void {
  //   this.http.delete('http://localhost:8080/bibliothecaire/' + this.id_to_delete).subscribe(
  //     (response: any) => {
  //       if (response) {
  //         console.log('le livre supprimé est : ', response.titre );
  //         console.log('http://localhost:8080/bibliothecaire/' + this.id_to_delete);
  //       } else {
  //         this.errorMessageDelete = "Erreur dans la saisie";
  //       }
  //     }
  //   );
  // }

  // UpdateBook(): void {
  //   const updateRequest = {
  //     id: this.id_to_update,
  //     titre: this.titre_to_update,
  //     id_auteur: this.id_auteur_to_update,
  //     id_type: this.id_type_to_update
  //   };
  //   this.http.put('http://localhost:8080/bibliothecaire', updateRequest).subscribe(
  //     (response: any) => {
  //       if (response) {
  //         console.log('le livre : ', this.titre_to_update, ' a était modifié');
  //       } else {
  //         this.errorMessageUpdate = "Erreur dans la saisie";
  //       }
  //     }
  //   );
  // }

  // GetBooks(): void {
  //   this.http.get('http://localhost:8080/bibliothecaire').subscribe(
  //     (response: any) => {
  //       if (response) {
  //         console.log(response);
  //         response.filter((e: any) => console.log(e))
  //         response.forEach((e: any) => {
  //           // this.booksIdO +=  e.id  += " / ";
  //           this.booksIdT += e.titre += " / ";
  //           // this.booksIdA += e.id_auteur += " / ";
  //           // this.booksIdT += e.id_type += " / ";
  //         });
  //       } else {
  //         this.errorMessageUpdate = "Erreur dans la saisie";
  //       }
  //     }
  //   );
  // }
}
