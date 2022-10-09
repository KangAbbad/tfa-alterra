import { PassengerService } from './services/passenger/passenger.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleService } from './services/article/article.service';
import { AuthService } from './services/auth/auth.service';
import { SessionService } from './services/session/session.service';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [ArticleService, AuthService, PassengerService, SessionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
