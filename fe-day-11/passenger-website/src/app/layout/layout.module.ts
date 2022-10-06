import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { RouterModule } from "@angular/router";

import { DashboardLayoutComponent } from "./dashboard-layout/dashboard-layout.component";
import { AuthLayoutComponent } from "./auth-layout/auth-layout.component";

@NgModule({
  declarations: [
      DashboardLayoutComponent,
      AuthLayoutComponent,
  ],
  imports: [
      BrowserModule,
      RouterModule,
  ],
  exports: [
    DashboardLayoutComponent,
    AuthLayoutComponent,
  ]
})
export class LayoutModule { }