import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router'
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { PassengerService } from './services/passenger.service';
import { PassengerFormComponent } from './pages/passengers/components/passenger-form/passenger-form.component';
import { PassengerListComponent } from './pages/passengers/components/passenger-list/passenger-list.component';
import { PassengersComponent } from './pages/passengers/passengers.component';
import { PassengerDetailComponent } from './pages/passenger-detail/passenger-detail.component';
import { ArticlesComponent } from './pages/articles/articles.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactUsComponent } from './pages/contact-us/contact-us.component';
import { ArticleListComponent } from './pages/articles/components/article-list/article-list.component';
import { ArticleFormComponent } from './pages/articles/components/article-form/article-form.component';
import { ArticleService } from './services/article.service';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'passengers', component: PassengersComponent },
  { path: 'passengers/:id', component: PassengerDetailComponent },
  { path: 'articles', component: ArticlesComponent },
  { path: 'about', component: AboutComponent },
  { path: 'contact-us', component: ContactUsComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    PassengersComponent,
    PassengerFormComponent,
    PassengerListComponent,
    HomepageComponent,
    PassengerDetailComponent,
    ArticlesComponent,
    AboutComponent,
    ContactUsComponent,
    ArticleListComponent,
    ArticleFormComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [PassengerService, ArticleService],
  bootstrap: [AppComponent]
})

export class AppModule { }
