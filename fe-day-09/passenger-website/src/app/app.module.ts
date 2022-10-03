import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router'

import { AppComponent } from './app.component';
import { PassengerListComponent } from './passengers/components/passenger-list/passenger-list.component';
import { PassengerFormComponent } from './passengers/components/passenger-form/passenger-form.component';
import { PassengersComponent } from './passengers/passengers.component';
import { HomepageComponent } from './homepage/homepage.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'passengers', component: PassengersComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    PassengerListComponent,
    PassengerFormComponent,
    PassengersComponent,
    HomepageComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
