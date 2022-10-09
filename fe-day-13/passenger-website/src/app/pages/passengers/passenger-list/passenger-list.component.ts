import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { IPassenger } from 'src/app/models/IPassenger';
import { PassengerService } from 'src/app/services/passenger/passenger.service';

@Component({
  selector: 'app-passenger-list',
  templateUrl: './passenger-list.component.html',
})
export class PassengerListComponent implements OnInit {
  title: string = 'Passenger Website';
  passengerForm: FormGroup = new FormGroup({});
  selectedPassengerIndex: number | null = null;
  isSubmitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private passengerService: PassengerService) {}

  ngOnInit(): void {
    this.passengerForm = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      name: ['', Validators.required],
      city: ['', Validators.required],
    });
  }

  private onEdit(): void {
    if (this.selectedPassengerIndex !== null) {
      this.passengerService.onEdit(this.passengerForm.value, this.selectedPassengerIndex);
    }
  }

  private onAdd(): void {
    this.passengerService.onAdd(this.passengerForm.value);
  }

  onEditPreview({ passenger, passengerIndex }: { passenger: IPassenger, passengerIndex: number }): void {
    this.selectedPassengerIndex = passengerIndex;
    this.passengerForm.setValue(passenger);
  }

  onSubmit(): void {
    this.isSubmitted = true;

    if (!this.passengerForm.invalid) {
      if (this.selectedPassengerIndex !== null) {
        this.onEdit();
      } else {
        this.onAdd();
      }

      this.selectedPassengerIndex = null;
      this.isSubmitted = false;
      this.passengerForm.reset();
    }
  }
}
