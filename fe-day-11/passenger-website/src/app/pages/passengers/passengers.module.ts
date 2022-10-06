import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';

import { PassengersRoutingModule } from './passengers-routing.module';
import { PassengerListComponent } from './passenger-list/passenger-list.component';
import { PassengerDetailComponent } from './passenger-detail/passenger-detail.component';
import { PassengerFormComponent } from './passenger-list/components/passenger-form/passenger-form.component';
import { PassengerTableComponent } from './passenger-list/components/passenger-table/passenger-table.component';

@NgModule({
  imports: [
    CommonModule,
    NgbModule,
    ReactiveFormsModule,
    PassengersRoutingModule,
  ],
  declarations: [
    PassengerListComponent,
    PassengerFormComponent,
    PassengerTableComponent,
    PassengerDetailComponent,
  ],
})
export class PassengersModule { }
