import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { PassengerService } from 'src/app/services/passenger.service';
import { IPassenger } from '../../../models/IPassenger';

@Component({
  selector: 'app-passenger-list',
  templateUrl: './passenger-list.component.html',
  styleUrls: ['./passenger-list.component.css']
})
export class PassengerListComponent implements OnInit {
  @Input() passengers: IPassenger[] = [];
  @Output() onEditPreview = new EventEmitter<{ passenger: IPassenger, passengerIndex: number }>();

  constructor(private passengerService: PassengerService) { }

  ngOnInit(): void {
  }

  getPassengers(): IPassenger[] {
    return this.passengerService.getPassengers();
  }

  onEdit(passenger: IPassenger, passengerIndex: number): void {
    this.onEditPreview.emit({ passenger: passenger, passengerIndex: passengerIndex });
  }

  onDelete(passengerIndex: number): void {
    this.passengerService.onDelete(passengerIndex);
  }
}
