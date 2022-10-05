import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { isEqual } from 'lodash';

import { IArticle } from 'src/app/models/IArticle';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.css']
})
export class ArticleFormComponent implements OnInit {
  isSubmitted: boolean = false;
  articleForm!: FormGroup;
  destroy$: Subject<boolean> = new Subject<boolean>();

  constructor(private formBuilder: FormBuilder, private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleForm = this.formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
    });
  }

  ngDoCheck(): void {
    const isFormFilled = Object.values(this.articleForm.value).every((value) => value);
    if (this.articleService.getSelectedArticle() && !isFormFilled) {
      const { id, ...rest } = this.articleService.getSelectedArticle();
      this.articleForm.setValue(rest);
    }
  }

  ngOnChanges(): void {
    console.log('ngOnChanges');
  }

  onResetForm(): void {
    this.isSubmitted = false;
    this.articleForm.reset();
    this.articleService.setSelectedArticle(null);
  }

  onSubmit(): void {
    this.isSubmitted = true;

    if (!this.articleForm.invalid) {
      if (this.articleService.getSelectedArticle()) {
        const payload: IArticle = {
          id: this.articleService.getSelectedArticle().id,
          ...this.articleForm.value,
        };
        this.articleService.httpUpdateArticle(payload)
          .subscribe(() => {
            setTimeout(() => {
              this.onResetForm();
            }, 500);
            this.articleService.httpGetArticles();
          });
      } else {
        this.articleService.httpCreateArticle(this.articleForm.value)
          .subscribe(() => {
            setTimeout(() => {
              this.onResetForm();
            }, 500);
            this.articleService.httpGetArticles();
          });
      }
    }
  }
}
