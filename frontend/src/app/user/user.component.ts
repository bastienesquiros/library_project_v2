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

  constructor(private http: HttpClient, private router: Router) {
  }

  GetUserById() : void {
    this.http.get("http://localhost:8080/utilisateur?id=" + this.id_user).subscribe (
      (response: any) => {
        if (response) {
          console.log("l'utilisateur recherché est : ", response.titre );
        }
      }
    )
  }

  DeleteUserById() : void {
    this.http.delete("http://localhost:8080/utilisateur/" + this.id_user).subscribe (
      (response: any) => {
        if (response) {
          console.log("l'utilisateur supprimé est : ", response.login );
        }
      }
    )
  }
}
