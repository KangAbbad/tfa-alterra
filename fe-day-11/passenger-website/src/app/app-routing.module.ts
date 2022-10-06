import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppLayoutComponent } from './layout/app-layout.component';
import { AuthLayoutComponent } from './layout/auth-layout.component';
import { NotfoundComponent } from './pages/notfound/notfound.component';

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        {
          path: '',
          redirectTo: 'auth/login',
          pathMatch: 'full'
        },
        {
          path: 'auth',
          component: AuthLayoutComponent,
          loadChildren: () => import('./pages/auth/auth.module').then(m => m.AuthModule),
        },
        {
          path: 'dashboard',
          component: AppLayoutComponent,
          children: [
            { path: '', loadChildren: () => import('./pages/homepage/homepage.module').then(m => m.HomepageModule) },
            { path: 'passengers', loadChildren: () => import('./pages/passengers/passengers.module').then(m => m.PassengersModule) },
            { path: 'articles', loadChildren: () => import('./pages/articles/articles.module').then(m => m.ArticlesModule) },
            { path: 'about', loadChildren: () => import('./pages/about/about.module').then(m => m.AboutModule) },
            { path: 'contact-us', loadChildren: () => import('./pages/contact-us/contact-us.module').then(m => m.ContactUsModule) },
          ],
        },
        { path: 'notfound', component: NotfoundComponent },
        { path: '**', redirectTo: 'notfound' },
      ],
      { scrollPositionRestoration: 'enabled', anchorScrolling: 'enabled', onSameUrlNavigation: 'reload' },
    ),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
