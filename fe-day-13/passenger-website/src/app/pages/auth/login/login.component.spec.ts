import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';

import { AuthService } from 'src/app/services/auth/auth.service';
import { LoginComponent } from './login.component';
import { By } from '@angular/platform-browser';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule],
      providers: [AuthService],
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('should invalid when forms are empty', () => {
    expect(component.loginForm.valid).toBeFalsy();
  });

  it('should valid email', () => {
    component.loginForm.setValue({
      email: 'someone@email.com',
      password: '',
    });
    expect(component.loginForm.controls['email'].errors).toBeFalsy();
  });

  it('should valid password', () => {
    component.loginForm.setValue({
      email: '',
      password: '123123',
    });
    expect(component.loginForm.controls['password'].errors).toBeFalsy();
  });

  it('should valid form', () => {
    const validForm = {
      email: 'someone@email.com',
      password: '123123',
    };
    component.loginForm.setValue(validForm);
    expect(component.loginForm.value).toEqual(validForm);
  });

  it('should submit form when submit button is clicked', () => {
    const submitBtnElm = fixture.debugElement.query(By.css('button[type=submit]'));
    const submitFunc = spyOn(component, 'onSubmit');

    (submitBtnElm.nativeElement as HTMLButtonElement).click();
    fixture.detectChanges();

    expect(submitFunc).toHaveBeenCalled();
  });

  it('should call onSubmit method', () => {
    const formElm = fixture.debugElement.query(By.css('form'));
    const submitFunc = spyOn(component, 'onSubmit');

    formElm.triggerEventHandler('ngSubmit', null);

    expect(submitFunc).toHaveBeenCalled();
  });
});
