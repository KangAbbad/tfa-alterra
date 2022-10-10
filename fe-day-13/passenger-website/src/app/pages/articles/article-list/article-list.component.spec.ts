import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';

import { ArticleService } from 'src/app/services/article/article.service';
import { ArticleListComponent } from './article-list.component';
import { ArticleFormComponent } from './components/article-form/article-form.component';
import { ArticleTableComponent } from './components/article-table/article-table.component';

describe('ArticleListComponent', () => {
  let component: ArticleListComponent;
  let fixture: ComponentFixture<ArticleListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticleListComponent, ArticleFormComponent, ArticleTableComponent ],
      imports: [ReactiveFormsModule, HttpClientTestingModule],
      providers: [ArticleService],
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
