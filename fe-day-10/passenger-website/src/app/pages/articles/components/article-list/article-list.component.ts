import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

import { IArticle } from 'src/app/models/IArticle';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
  destroy$: Subscription = new Subscription();

  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleService.httpGetArticles();
  }

  ngOnDestroy(): void {
    this.destroy$.unsubscribe();
  }

  getArticles(): IArticle[] {
    return this.articleService.getArticles();
  }

  onEdit(article: IArticle): void {
    this.articleService.setSelectedArticle(article);
  }

  onDelete(id: number | undefined): void {
    this.destroy$ = this.articleService.httpDeleteArticle(id as number).subscribe(() => {
      this.articleService.httpGetArticles();
    });
  }
}
