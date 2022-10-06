import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { ArticleDetailComponent } from "./article-detail/article-detail.component";
import { ArticleListComponent } from "./article-list/article-list.component";
import { ArticleFormComponent } from "./article-list/components/article-form/article-form.component";
import { ArticleTableComponent } from "./article-list/components/article-table/article-table.component";
import { ArticlesRoutingModule } from "./articles-routing.module";

@NgModule({
  imports: [
    CommonModule,
    NgbModule,
    ReactiveFormsModule,
    ArticlesRoutingModule,
  ],
  declarations: [
    ArticleListComponent,
    ArticleFormComponent,
    ArticleTableComponent,
    ArticleDetailComponent,
  ],
})
export class ArticlesModule { }