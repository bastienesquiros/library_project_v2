import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

interface Emprunt {
  id_emprunt: number;
  etat_emprunt: string;
  date_debut_emprunt: string | null;
  date_fin_emprunt_attendue: string | null;
  date_fin_emprunt_reel: string | null;
  exemplaire: {
    id_exemplaire: number; 
  };
  abonne: {
    id_abonne: number;
  };
}
@Component({
  selector: 'app-emprunter',
  templateUrl: './emprunter.component.html',
  styleUrls: ['./emprunter.component.css']
})

export class EmprunterComponent implements OnInit {
  public emprunts: Emprunt[] = [];
  searchText: string = '';
  filteredEmprunt: Emprunt[] = [];
  newEmprunt: Emprunt = {
    id_emprunt: 0,
    etat_emprunt: '',
    date_debut_emprunt: null,
    date_fin_emprunt_attendue: null,
    date_fin_emprunt_reel: null,
    exemplaire: {
      id_exemplaire: 0,
    },
    abonne: {
      id_abonne: 0
    }
  };

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.getAllEmprunts();
  }

  getAllEmprunts(): void {
    this.http.get<Emprunt[]>('http://localhost:8080/emprunt').subscribe(
      (response: Emprunt[]) => {
        this.emprunts = response;
        this.filterEmprunt();
      }
    );
  }

  filterEmprunt() {
    if (this.searchText.trim() === '') {
      this.filteredEmprunt = this.emprunts;
    } else {
      this.filteredEmprunt = this.emprunts.filter(emprunt =>
        emprunt.exemplaire.id_exemplaire.toString().includes(this.searchText.trim()) ||
        emprunt.abonne.id_abonne.toString().includes(this.searchText.trim()) ||
        emprunt.id_emprunt.toString().includes(this.searchText.trim())
      );
    }
  }

  deleteEmprunt(emprunt: Emprunt): void {
    this.http.delete(`http://localhost:8080/emprunt/${emprunt.id_emprunt}`).subscribe(
      (response: any) => {
        this.getAllEmprunts();
      }
    );
  }

  editEmprunt(emprunt: Emprunt): void {
    this.newEmprunt = {...emprunt};
  }

  submitForm(): void {
    if (this.newEmprunt.id_emprunt) {
      const requestPut = {
        id_emprunt: this.newEmprunt.id_emprunt,
        etat_emprunt: this.newEmprunt.etat_emprunt,
        date_debut_emprunt: this.newEmprunt.date_debut_emprunt,
        date_fin_emprunt_attendue: this.newEmprunt.date_fin_emprunt_attendue,
        date_fin_emprunt_reel: this.newEmprunt.date_fin_emprunt_reel,
        exemplaire: {
          id_exemplaire: this.newEmprunt.exemplaire.id_exemplaire,
        },
        abonne: {
          id_abonne: this.newEmprunt.abonne.id_abonne
        }
      };

      this.http.put('http://localhost:8080/emprunt', requestPut).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    } else {
      const requestPost = {
        etat_emprunt: this.newEmprunt.etat_emprunt,
        date_debut_emprunt: this.newEmprunt.date_debut_emprunt,
        date_fin_emprunt_attendue: this.newEmprunt.date_fin_emprunt_attendue,
        date_fin_emprunt_reel: this.newEmprunt.date_fin_emprunt_reel,
        exemplaire: {
          id_exemplaire: this.newEmprunt.exemplaire.id_exemplaire,
        },
        abonne: {
          id_abonne: this.newEmprunt.abonne.id_abonne
        }
      };

      this.http.post('http://localhost:8080/emprunt', requestPost).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    }
  }


  private handleFormSubmission(): void {
    this.getAllEmprunts();
    this.resetFormFields();
  }

  private resetFormFields(): void {
    this.newEmprunt = {
      id_emprunt: 0,
      etat_emprunt: '',
      date_debut_emprunt: null,
      date_fin_emprunt_attendue: null,
      date_fin_emprunt_reel: null,
      exemplaire: {
        id_exemplaire: 0
      },
      abonne: {
        id_abonne: 0
      }
    };
  }
}
