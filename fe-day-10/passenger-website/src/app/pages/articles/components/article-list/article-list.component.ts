import { Component, OnInit } from '@angular/core';

import { IArticle } from 'src/app/models/IArticle';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleService.httpGetArticles();
  }

  getArticles(): IArticle[] {
    return this.articleService.getArticles();
  }

  onEdit(article: IArticle): void {
    this.articleService.setSelectedArticle(null);
    setTimeout(() => {
      this.articleService.setSelectedArticle(article);
    }, 500);
  }

  onDelete(id: number | undefined): void {
    this.articleService.httpDeleteArticle(id as number).subscribe(() => {
      this.articleService.httpGetArticles();
    });
  }
}
