import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import { AnonymousSubject } from 'rxjs/internal/Subject';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {
  titre: string = '';
  titre_to_update: string = '';
  auteur: number = 0;
  auteur_to_update: number = 0;
  id_type: number = 0;
  id_type_to_update: number = 0;
  id_ouvrage: number = 0;
  id_ouvrage_to_delete: number = 0;
  id_ouvrage_to_update: number = 0;
  errorMessage: string = '';
  errorMessageDelete: string = '';
  errorMessageGetById: string = '';
  errorMessageUpdate: string = '';
  errorMessageGet: string = '';
  bookById: string = '';
  booksIdO: string = '';
  booksTitre: string = '';
  booksIdA: string = '';
  booksIdT: string = '';

  constructor(private http: HttpClient, private router: Router) {
  }


  PostBook(): void {
    const bookRequest = {
      titre: this.titre,
      auteur: this.auteur,
      id_type: this.id_type
    };
    
    this.http.post('http://localhost:8080/bibliothecaire', bookRequest).subscribe(
      (response: any) => {
        if (response) {
          console.log('le livre : ', this.titre, ' a était ajouté');
        } else {
          this.errorMessage = "Erreur dans la saisie";
        }
      }
    );
  }

  GetBookById(): void {
    this.http.get('http://localhost:8080/bibliothecaire/ouvrage?id_ouvrage=' + this.id_ouvrage).subscribe(
      (response: any) => {
        if (response) {
          console.log('le livre recherché est : ', response.titre );
          this.bookById = response.titre;
        } else {
          this.errorMessageGetById = "Erreur dans la saisie";
        }
      }
    );
  }

  DeleteBook(): void {
    this.http.delete('http://localhost:8080/bibliothecaire/' + this.id_ouvrage_to_delete).subscribe(
      (response: any) => {
        if (response) {
          console.log('le livre supprimé est : ', response.titre );
          console.log('http://localhost:8080/bibliothecaire/' + this.id_ouvrage_to_delete);
        } else {
          this.errorMessageDelete = "Erreur dans la saisie";
        }
      }
    );
  }

  UpdateBook(): void {
    const updateRequest = {
      id_ouvrage: this.id_ouvrage_to_update,
      titre: this.titre_to_update,
      auteur: this.auteur_to_update,
      id_type: this.id_type_to_update
    };
    this.http.put('http://localhost:8080/bibliothecaire', updateRequest).subscribe(
      (response: any) => {
        if (response) {
          console.log('le livre : ', this.titre_to_update, ' a était modifié');
        } else {
          this.errorMessageUpdate = "Erreur dans la saisie";
        }
      }
    );
  }

  GetBooks(): void {
    this.http.get('http://localhost:8080/bibliothecaire').subscribe(
      (response: any) => {
        if (response) {
          console.log(response);
          response.filter((e: any) => console.log(e))
          response.forEach((e: any) => {
            // this.booksIdO +=  e.id_ouvrage  += " / ";
            this.booksIdT += e.titre += " / ";
            // this.booksIdA += e.auteur += " / ";
            // this.booksIdT += e.id_type += " / ";
          });
        } else {
          this.errorMessageUpdate = "Erreur dans la saisie";
        }
      }
    );
  }
}
