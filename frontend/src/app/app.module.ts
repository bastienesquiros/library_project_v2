import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {FormsModule} from "@angular/forms";
import {SignupComponent} from './signup/signup.component';
import {HomeComponent} from './home/home.component';
import {SubscriberSideComponent} from './subscriber-side/subscriber-side.component';
import {LibrarianSideComponent} from './librarian-side/librarian-side.component';
import {BookComponent} from './book/book.component';
import {UserComponent} from './user/user.component';
import {EmprunterComponent} from './emprunter/emprunter.component';
import {AbonneComponent} from './abonne/abonne.component';
import {TypeBookComponent} from './type-book/type-book.component';
import { AuteurComponent } from './auteur/auteur.component';
import { ReservationComponent } from './reservation/reservation.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    SubscriberSideComponent,
    LibrarianSideComponent,
    BookComponent,
    UserComponent,
    EmprunterComponent,
    AbonneComponent,
    TypeBookComponent,
    AuteurComponent,
    ReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
