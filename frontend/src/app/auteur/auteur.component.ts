import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

interface Auteur {
  id_auteur: number;
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

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllAuteurs();
  };

  getAllAuteurs() : void {
    this.http.get<Auteur[]>("http://localhost:8080/auteur").subscribe (
      (response: Auteur[]) => {
        this.auteurs = response;
        this.filterAuteurs()
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
        auteur.id_auteur.toString().includes(this.searchText.trim()) ||
        auteur.nom.toString().includes(this.searchText.trim())
      );
    }
  }

  DeleteAuteur() : void {
    this.http.delete('http://localhost:8080/auteur/').subscribe(
      (response: any) => {
        if (response) {
          console.log("l'auteur supprimé est : ", response.nom );
        }
      }
    );
  }
}
