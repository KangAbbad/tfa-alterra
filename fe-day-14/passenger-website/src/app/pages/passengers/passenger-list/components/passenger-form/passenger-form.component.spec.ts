import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormBuilder, FormControl, FormGroup, FormGroupDirective, ReactiveFormsModule, Validators } from '@angular/forms';

import { PassengerFormComponent } from './passenger-form.component';

describe('PassengerFormComponent', () => {
  let component: PassengerFormComponent;
  let fixture: ComponentFixture<PassengerFormComponent>;

  beforeEach(async () => {
    const formBuilder = new FormBuilder();

    const formGroupDirective = new FormGroupDirective([], []);
    formGroupDirective.form = formBuilder.group({
      id: formBuilder.control('', [Validators.required, Validators.pattern('^[0-9]*$')]),
      name: formBuilder.control('', Validators.required),
      city: formBuilder.control('', Validators.required),
    });

    await TestBed.configureTestingModule({
      declarations: [ PassengerFormComponent ],
      imports: [ReactiveFormsModule],
      providers: [
        FormBuilder,
        FormGroupDirective,
        { provide: FormGroupDirective, useValue: formGroupDirective }
      ],
    })
    .compileComponents();

    fixture = TestBed.createComponent(PassengerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
