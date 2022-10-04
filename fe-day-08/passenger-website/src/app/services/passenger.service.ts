import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { IPassenger } from '../models/IPassenger';

@Injectable()
export class PassengerService {
  private passengers: BehaviorSubject<IPassenger[]> = new BehaviorSubject<IPassenger[]>([]);

  constructor() { }

  getPassengers(): IPassenger[] {
    return this.passengers.value;
  }

  setPassengers(passengers: IPassenger[]): void {
    this.passengers.next(passengers);
  }

  onAdd(passenger: IPassenger): void {
    const newPassengers = [...this.getPassengers(), passenger];
    this.setPassengers(newPassengers);
  }

  onEdit(passenger: IPassenger, passengerIndex: number): void {
    const newPassengers = [...this.getPassengers()];
    newPassengers.splice(passengerIndex, 1, passenger);
    this.setPassengers(newPassengers);
  }

  onDelete(passengerIndex: number): void {
    const newPassengers = [...this.getPassengers()];
    newPassengers.splice(passengerIndex, 1);
    this.setPassengers(newPassengers);
  }
}
