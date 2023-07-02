import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {FormsModule} from "@angular/forms";
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { SubscriberSideComponent } from './subscriber-side/subscriber-side.component';
import { LibrarianSideComponent } from './librarian-side/librarian-side.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    SubscriberSideComponent,
    LibrarianSideComponent
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
