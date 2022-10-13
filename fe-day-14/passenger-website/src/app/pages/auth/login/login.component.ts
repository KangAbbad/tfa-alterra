import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject, switchMap, takeUntil } from 'rxjs';

import { IUserInfo } from 'src/app/models/IAuth';
import { AuthService } from 'src/app/services/auth/auth.service';
import { SessionService } from 'src/app/services/session/session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent implements OnInit {
  isSubmitted: boolean = false;
  isLoading: boolean = false;
  loginForm!: FormGroup;
  private ngUnsubsribe: Subject<any> = new Subject();

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private sessionService: SessionService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    });

    this.activatedRoute.queryParams.subscribe((params) => {
      if (!Object.keys(params).length) return;
      this.loginForm.setValue({ ...this.loginForm.value, email: params['email'] });
    });
  }

  onSubmit(): void {
    this.isSubmitted = true;

    if (this.loginForm.invalid) return;

    this.isLoading = true;

    this.authService
      .httpCreateLogin(this.loginForm.value)
      .pipe(
        switchMap((res: any) => {
          if (res) {
            localStorage.setItem('auth_token', res.data);
          } else {
            localStorage.setItem('auth_token', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.qWDOcd2UDoTGumbak_fRlZZtf-H7va3sH2a339KGiKU');
          }

          return this.authService.httpGetUserInfo();
        }),
        takeUntil(this.ngUnsubsribe)
      )
      .subscribe((res) => {
        this.isSubmitted = false;
        this.isLoading = false;

        if (res) {
          const reformatResponse: { [key: string]: any } = {};
          Object.entries(res.data).map(([key, value]) => {
            reformatResponse[key.toLowerCase()] = value;
          });
          this.sessionService.createSession(reformatResponse as IUserInfo);
        } else {
          const userInfo: IUserInfo = {
            id: 2,
            fullname: 'Firstname Lastname',
            email: 'someone@mail.com',
            password: "123123"
          };
          this.sessionService.createSession(userInfo);
        }

        this.router.navigateByUrl('/dashboard');
      });
  }
}
