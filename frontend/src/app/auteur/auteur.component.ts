import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

interface Auteur {
  id: number;
  nom: string;
}

@Component({
  selector: 'app-auteur',
  templateUrl: './auteur.component.html',
  styleUrls: ['./auteur.component.css']
})
export class AuteurComponent {
  public auteurs: Auteur[] = []

  searchText: string = '';
  filteredAuteurs: any[] = [];

  newAuteur: Auteur = {
    id: 0,
    nom: ''
  }

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllAuteurs();
  };

  getAllAuteurs() : void {
    this.http.get<Auteur[]>("http://localhost:8080/auteur").subscribe (
      (response: Auteur[]) => {
        this.auteurs = response;
        this.filterAuteurs();
      }
    )
  }

  filterAuteurs() : void {
    if (this.searchText.trim() === '') {
      // If search text is empty, show all abonnes
      this.filteredAuteurs = this.auteurs;
    } else {
      // Filter auteurs based on search text
      this.filteredAuteurs = this.auteurs.filter(auteur =>
        auteur.id.toString().includes(this.searchText.trim()) ||
        auteur.nom.toString().includes(this.searchText.trim())
      );
    }
  }

  DeleteAuteur(auteur: Auteur) : void {
    this.http.delete('http://localhost:8080/auteur/' + auteur.id).subscribe(
      (response: any) => {
        if (response) {
          console.log("l'auteur supprimé est : ", response.nom );
          this.getAllAuteurs();
        }
      }
    );
  }

  editAuteur(auteur: Auteur): void {
    this.newAuteur = {...auteur}; // Set the form fields with the selected abonne data
  }

  submitForm(): void {
    if (this.newAuteur.id) {
      const requestPut = {
        id: this.newAuteur.id,
        nom: this.newAuteur.nom
      };

      this.http.put('http://localhost:8080/auteur', requestPut).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    } else {
      const requestPost = {
        id: this.newAuteur.id,
        nom: this.newAuteur.nom
      };

      this.http.post('http://localhost:8080/auteur', requestPost).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    }
  }

  private handleFormSubmission(): void {
    this.getAllAuteurs();
    this.resetFormFields();
  }

  private resetFormFields(): void {
    this.newAuteur = {
      id: 0,
      nom: ''
    };
  }

}
