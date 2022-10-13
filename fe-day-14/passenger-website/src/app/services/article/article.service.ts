import { catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry, Subscription, throwError } from 'rxjs';

import { IArticle } from 'src/app/models/IArticle';

@Injectable()
export class ArticleService {
  articles: IArticle[] = [];
  selectedArticle: IArticle | null = null;
  private url: string = 'http://localhost:3000/articles';
  destroy$: Subscription = new Subscription();

  constructor(private http: HttpClient) { }

  ngOnDestroy(): void {
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
    // return this.http.post(this.url, body).pipe(takeUntil(this.destroy$));
    return this.http.post(this.url, body).pipe(retry(1), catchError(this.handleError));
  }

  httpGetArticles(): void {
    this.destroy$ = this.http.get(this.url)
      .pipe(retry(1), catchError(this.handleError))
      .subscribe((response) => {
        this.setArticles(response as IArticle[]);
      });
  }

  httpUpdateArticle(body: IArticle): Observable<Object> {
    return this.http.put(`${this.url}/${body.id}`, body).pipe(retry(1), catchError(this.handleError));
  }

  httpDeleteArticle(id: number): Observable<Object> {
    return this.http.delete(`${this.url}/${id}`).pipe(retry(1), catchError(this.handleError));
  }

  handleError(error: any): Observable<any> {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error code: ${error.status}\nMessage: ${error.message}`;
    }
    console.error(errorMessage);
    return throwError(() => errorMessage);
  }
}
