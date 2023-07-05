import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

interface Abonne {
  id_abonne: number;
  id_utilisateur: number;
  date_debut_penalite: Date;
  date_fin_penalite: Date;
  nb_infraction: number;


}

@Component({
  selector: 'app-abonne',
  templateUrl: './abonne.component.html',
  styleUrls: ['./abonne.component.css']
})


export class AbonneComponent implements OnInit {
  public abonnes: Abonne[] = [];
  searchText: string = '';
  filteredAbonnes: Abonne[] = [];
  newAbonne: Abonne = {
    id_abonne: 0,
    id_utilisateur: 0,
    date_debut_penalite: new Date(),
    date_fin_penalite: new Date(),
    nb_infraction: 0
  };


  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
    this.getAllAbonnes();
  };

  getAllAbonnes(): void {
    this.http.get<Abonne[]>('http://localhost:8080/abonne').subscribe(
      (response: Abonne[]) => {
        this.abonnes = response;
        this.filterAbonnes()
      }
    );
  }


  filterAbonnes() {
    if (this.searchText.trim() === '') {
      this.filteredAbonnes = this.abonnes;
    } else {
      this.filteredAbonnes = this.abonnes.filter(abonne =>
        abonne.id_utilisateur.toString().includes(this.searchText.trim()) ||
        abonne.id_abonne.toString().includes(this.searchText.trim())
      );
    }
  }


  deleteAbonne(abonne: Abonne): void {
    this.http.delete('http://localhost:8080/abonne/' + abonne.id_abonne).subscribe(
      (response: any) => {
        this.getAllAbonnes();
      }
    )
  }


  editAbonne(abonne: Abonne): void {
    this.newAbonne = {...abonne}; // Set the form fields with the selected abonne data
  }


  submitForm(): void {
    if (this.newAbonne.id_abonne) {
      const requestPut = {
        id_abonne: this.newAbonne.id_abonne,
        id_utilisateur: this.newAbonne.id_utilisateur,
        date_debut_penalite: this.newAbonne.date_debut_penalite,
        date_fin_penalite: this.newAbonne.date_fin_penalite,
        nb_infraction: this.newAbonne.nb_infraction
      };


      this.http.put('http://localhost:8080/abonne', requestPut).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    } else {
      const requestPost = {
        id_utilisateur: this.newAbonne.id_utilisateur,
        date_debut_penalite: this.newAbonne.date_debut_penalite,
        date_fin_penalite: this.newAbonne.date_fin_penalite,
        nb_infraction: this.newAbonne.nb_infraction
      };

      this.http.post('http://localhost:8080/abonne', requestPost).subscribe((response: any) => {
        this.handleFormSubmission();
      });
    }
  }


  private handleFormSubmission(): void {
    this.getAllAbonnes();
    this.resetFormFields();
  }

  private resetFormFields(): void {
    this.newAbonne = {
      id_abonne: 0,
      id_utilisateur: 0,
      date_debut_penalite: new Date(),
      date_fin_penalite: new Date(),
      nb_infraction: 0
    };
  }


}
