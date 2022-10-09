import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";

import { ArticleDetailComponent } from "./article-detail/article-detail.component";
import { ArticleListComponent } from "./article-list/article-list.component";

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: '', component: ArticleListComponent },
      { path: ':id', component: ArticleDetailComponent },
    ]),
  ],
  exports: [RouterModule]
})
export class ArticlesRoutingModule { }