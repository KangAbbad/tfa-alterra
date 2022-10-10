import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';

import { PassengerService } from './services/passenger/passenger.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleService } from './services/article/article.service';
import { AuthService } from './services/auth/auth.service';
import { SessionService } from './services/session/session.service';
import { LayoutModule } from './layout/layout.module';
import { NotfoundComponent } from './pages/notfound/notfound.component';
import { HttpInterceptorInterceptor } from './core/interceptor/http-interceptor.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NotfoundComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    LayoutModule,
  ],
  providers: [
    { provide: LocationStrategy, useClass: HashLocationStrategy },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorInterceptor,
      multi: true
    },
    PassengerService,
    ArticleService,
    AuthService,
    SessionService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
