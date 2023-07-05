import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LibrarianSideComponent} from "./librarian-side/librarian-side.component";
import {SubscriberSideComponent} from "./subscriber-side/subscriber-side.component";
import {BookComponent} from "./book/book.component";
import {UserComponent} from "./user/user.component";
import {AbonneComponent} from "./abonne/abonne.component";
import {TypeBookComponent } from "./type-book/type-book.component";
import {AuteurComponent} from "./auteur/auteur.component";
import {ReservationComponent} from "./reservation/reservation.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'librarianside', component: LibrarianSideComponent},
  {path: 'subscriberside', component: SubscriberSideComponent},
  {path: 'managebooks', component: BookComponent},
  {path: 'manageusers', component: UserComponent},
  {path: 'managesubscribers', component: AbonneComponent},
  {path: 'managetypebooks', component: TypeBookComponent},
  {path: 'manageauthors', component: AuteurComponent},
  {path: 'managereservations', component: ReservationComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
