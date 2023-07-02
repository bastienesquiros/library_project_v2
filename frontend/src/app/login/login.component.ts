import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';


  constructor(private http: HttpClient, private router: Router) {
  }


  onSubmit(): void {
    const loginRequest = {
      login: this.username,
      mot_de_passe: this.password
    };
    this.http.post('http://localhost:8080/utilisateur/login', loginRequest).subscribe(
      (response: any) => {
        if (response.loginSuccessful == true) {
          if (response.librarian == true) {
            this.router.navigate(['/librarianside']);
          } else {
            this.router.navigate(['/subscriberside']);
          }
        } else {
          this.errorMessage = 'Login ou mot de passe incorrect';
        }
      }
    );
  }
}
