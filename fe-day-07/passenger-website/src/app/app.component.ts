import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IPassenger } from './dto/IPassenger';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = 'Passenger Website';
  passengerForm!: FormGroup;
  isSubmitted: boolean = false;
  passengers: IPassenger[] = [];
  selectedpassengerIndex: number | null = null;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.passengerForm = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      name: ['', Validators.required],
      city: ['', Validators.required],
    });
  }

  onSubmit(): void {
    this.isSubmitted = true;

    if (!this.passengerForm.invalid) {
      if (this.selectedpassengerIndex !== null) {
        this.passengers.splice(this.selectedpassengerIndex, 1, this.passengerForm.value);
      } else {
        this.passengers.push(this.passengerForm.value);
      }

      this.selectedpassengerIndex = null;
      this.isSubmitted = false;
      this.passengerForm.reset();
    }
  }

  onDelete({ passengerIndex }: { passengerIndex: number }): void {
    this.passengers.splice(passengerIndex, 1);
  }

  onEdit({ passenger, passengerIndex }: { passenger: IPassenger, passengerIndex: number }): void {
    this.selectedpassengerIndex = passengerIndex;
    this.passengerForm.setValue(passenger);
  }
}
