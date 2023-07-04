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
  filteredAbonnes: any[] = [];


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
      // If search text is empty, show all abonnes
      this.filteredAbonnes = this.abonnes;
    } else {
      // Filter abonnes based on search text
      this.filteredAbonnes = this.abonnes.filter(abonne =>
        abonne.id_utilisateur.toString().includes(this.searchText.trim()) ||
        abonne.id_abonne.toString().includes(this.searchText.trim())
      );
    }
  }

}
