import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { PassengerListComponent } from './passengers/components/passenger-list/passenger-list.component';
import { PassengerFormComponent } from './passengers/components/passenger-form/passenger-form.component';
import { PassengersComponent } from './passengers/passengers.component';
import { PassengerService } from './services/passenger.service';

@NgModule({
  declarations: [
    AppComponent,
    PassengerListComponent,
    PassengerFormComponent,
    PassengersComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    ReactiveFormsModule,
  ],
  providers: [PassengerService],
  bootstrap: [AppComponent]
})

export class AppModule { }
