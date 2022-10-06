import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { HomepageComponent } from './homepage.component';
import { HomepageRoutingModule } from './homepage-routing.module';

@NgModule({
  imports: [
    CommonModule,
    NgbModule,
    HomepageRoutingModule,
  ],
  declarations: [HomepageComponent],
})
export class HomepageModule { }
