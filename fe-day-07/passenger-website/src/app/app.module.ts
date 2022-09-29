import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { PassengerListComponent } from './passenger-list/passenger-list.component';
import { PassengerFormComponent } from './passenger-form/passenger-form.component';

@NgModule({
  declarations: [
    AppComponent,
    PassengerListComponent,
    PassengerFormComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
