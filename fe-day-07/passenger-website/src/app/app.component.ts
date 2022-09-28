import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

interface IPassangerForm {
  id: number;
  name: string;
  city: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = 'Passenger Website';
  passangerForm!: FormGroup;
  isSubmitted: boolean = false;
  passangers: IPassangerForm[] = [];
  selectedPassangerIndex: number | null = null;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.passangerForm = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      name: ['', Validators.required],
      city: ['', Validators.required],
    });
  }

  onSubmit(): void {
    this.isSubmitted = true;

    if (!this.passangerForm.invalid) {
      if (this.selectedPassangerIndex !== null) {
        this.passangers.splice(this.selectedPassangerIndex, 1, this.passangerForm.value);
      } else {
        this.passangers.push(this.passangerForm.value);
      }
    }

    this.selectedPassangerIndex = null;
    this.isSubmitted = false;
    this.passangerForm.reset();
  }

  onDelete(passangerIndex: number): void {
    this.passangers.splice(passangerIndex, 1);
  }

  onEdit(passanger: IPassangerForm, passangerIndex: number): void {
    this.selectedPassangerIndex = passangerIndex;
    this.passangerForm.setValue(passanger);
  }
}
