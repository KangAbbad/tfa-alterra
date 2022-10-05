import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, takeUntil } from 'rxjs';

import { IArticle } from 'src/app/models/IArticle';

@Injectable()
export class ArticleService {
  articles: IArticle[] = [];
  selectedArticle: IArticle | null = null;
  destroy$: Subject<boolean> = new Subject<boolean>();
  private url: string = 'http://localhost:3000/articles';

  constructor(private http: HttpClient) { }

  ngOnDestroy(): void {
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
  }

  getArticles(): IArticle[] {
    return this.articles;
  }

  setArticles(articles: IArticle[]): void {
    this.articles = articles;
  }

  getSelectedArticle(): IArticle {
    return this.selectedArticle as IArticle;
  }

  setSelectedArticle(article: IArticle | null): void {
    this.selectedArticle = article;
  }

  httpCreateArticle(body: IArticle): Observable<Object> {
    return this.http.post(this.url, body).pipe(takeUntil(this.destroy$));
  }

  httpGetArticles(): void {
    this.http.get(this.url)
      .pipe(takeUntil(this.destroy$))
      .subscribe((response) => {
        this.setArticles(response as IArticle[]);
      });
  }

  httpUpdateArticle(body: IArticle): Observable<Object> {
    return this.http.put(`${this.url}/${body.id}`, body).pipe(takeUntil(this.destroy$));
  }

  httpDeleteArticle(id: number): Observable<Object> {
    return this.http.delete(`${this.url}/${id}`).pipe(takeUntil(this.destroy$));
  }
}
