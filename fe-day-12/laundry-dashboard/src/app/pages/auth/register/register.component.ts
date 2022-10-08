import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class RegisterComponent implements OnInit {
  isSubmitted: boolean = false;
  isLoading: boolean = false;
  registerForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      name: ['', Validators.required],
      idCard: ['', Validators.required],
      address: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onSubmit(): void {
    console.log(this.registerForm.value);

    this.isSubmitted = true;

    if (this.registerForm.invalid) return;

    this.isLoading = true;

    // this.authService
    //   .httpCreateRegister(this.registerForm.value)
    //   .subscribe(res => {
    //     if (!res) return;

    //     this.router.navigate(['/auth/login'], {
    //       queryParams: {
    //         email: this.registerForm.value.email,
    //       },
    //     });

    //     this.isSubmitted = false;
    //     this.isLoading = false;
    //   });
  }
}
