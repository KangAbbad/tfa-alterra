import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { RouterModule } from "@angular/router";

import { AppLayoutComponent } from "./app-layout.component";
import { AuthLayoutComponent } from "./auth-layout.component";

@NgModule({
  declarations: [
      AppLayoutComponent,
      AuthLayoutComponent,
  ],
  imports: [
      BrowserModule,
      RouterModule,
  ],
  exports: [
    AppLayoutComponent,
    AuthLayoutComponent,
  ]
})
export class LayoutModule { }