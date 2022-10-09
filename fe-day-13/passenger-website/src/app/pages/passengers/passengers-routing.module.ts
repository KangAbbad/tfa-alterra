import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";

import { PassengerDetailComponent } from "./passenger-detail/passenger-detail.component";
import { PassengerListComponent } from "./passenger-list/passenger-list.component";

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: '', component: PassengerListComponent },
      { path: ':id', component: PassengerDetailComponent },
    ]),
  ],
  exports: [RouterModule]
})
export class PassengersRoutingModule { }