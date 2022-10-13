import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ChartModule } from 'primeng/chart';

import { AboutRoutingModule } from "./about-routing.module";
import { AboutComponent } from "./about.component";

@NgModule({
  imports: [
    CommonModule,
    AboutRoutingModule,
    ChartModule,
  ],
  declarations: [AboutComponent],
})
export class AboutModule { }