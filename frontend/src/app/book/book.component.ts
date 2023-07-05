import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

interface Ouvrage {
  id_ouvrage: number;
  titre: string;
  auteurs: {
    id: number;
    nom: string;
  };
  typeOuvrage: {
    id: number;
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
      id: 0,
      nom: ''
    },
    typeOuvrage: {
      id: 0,
      type: ''
    }
  }

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllOuvrage();
  };

  getAllOuvrage(): void {
    this.http.get<Ouvrage[]>("http://localhost:8080/bibliothecaire").subscribe(
      (response: Ouvrage[]) => {
        this.ouvrage = response;
        console.log(this.ouvrage);
        this.filterOuvrage();
      }
    )
  }

  filterOuvrage(): void {
    if (this.searchText.trim() === '') {
      // If search text is empty, show all abonnes
      this.filteredOuvrage = this.ouvrage;
    } else {
      // Filter auteurs based on search text
      this.filteredOuvrage = this.ouvrage.filter(ouvrage =>
        ouvrage.id_ouvrage.toString().includes(this.searchText.trim()) ||
        ouvrage.titre.toString().includes(this.searchText.trim()) ||
        ouvrage.auteurs.id.toString().includes(this.searchText.trim()) ||
        ouvrage.typeOuvrage.id.toString().includes(this.searchText.trim())
      );
    }
  }

  DeleteOuvrage(ouvrage: Ouvrage): void {
    this.http.delete('http://localhost:8080/bibliothecaire/' + ouvrage.id_ouvrage).subscribe(
      (response: any) => {
        if (response) {
          console.log("l'auteur supprimé est : ", response.nom);
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
        titre: this.newOuvrage.titre,
        auteur: {
          id: this.newOuvrage.auteurs.id
        },
        typeOuvrage: {
          id: this.newOuvrage.typeOuvrage.id
        },
      };

      this.http.put('http://localhost:8080/bibliothecaire', requestPut).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    } else {
      const requestPost = {
        titre: this.newOuvrage.titre,
        auteur: {
          id: this.newOuvrage.auteurs.id
        },
        typeOuvrage: {
          id: this.newOuvrage.typeOuvrage.id
        },
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
        id: 0,
        nom: ''
      },
      typeOuvrage: {
        id: 0,
        type: ''
      }
    };
  }
}
