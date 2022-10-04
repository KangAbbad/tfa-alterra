import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { IPassenger } from '../models/IPassenger';

@Component({
  selector: 'app-passengers',
  templateUrl: './passengers.component.html',
  styleUrls: ['./passengers.component.css']
})
export class PassengersComponent implements OnInit {
  title: string = 'Passenger Website';
  passengerForm!: FormGroup;
  isSubmitted: boolean = false;
  passengers: IPassenger[] = [];
  selectedPassengerIndex: number | null = null;

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
      if (this.selectedPassengerIndex !== null) {
        this.passengers.splice(this.selectedPassengerIndex, 1, this.passengerForm.value);
      } else {
        this.passengers.push(this.passengerForm.value);
      }

      this.selectedPassengerIndex = null;
      this.isSubmitted = false;
      this.passengerForm.reset();
    }
  }

  onDelete({ passengerIndex }: { passengerIndex: number }): void {
    this.passengers.splice(passengerIndex, 1);
  }

  onEdit({ passenger, passengerIndex }: { passenger: IPassenger, passengerIndex: number }): void {
    this.selectedPassengerIndex = passengerIndex;
    this.passengerForm.setValue(passenger);
  }
}
