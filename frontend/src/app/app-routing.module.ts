import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LibrarianSideComponent} from "./librarian-side/librarian-side.component";
import {SubscriberSideComponent} from "./subscriber-side/subscriber-side.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'librarianside', component: LibrarianSideComponent},
  {path: 'subscriberside', component: SubscriberSideComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
