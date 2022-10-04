import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IPassenger } from '../../../models/IPassenger';

@Component({
  selector: 'app-passenger-list',
  templateUrl: './passenger-list.component.html',
  styleUrls: ['./passenger-list.component.css']
})
export class PassengerListComponent implements OnInit {
  @Input() passengers: IPassenger[] = [];
  @Output() onEdit = new EventEmitter<{ passenger: IPassenger, passengerIndex: number }>();
  @Output() onDelete = new EventEmitter<{ passengerIndex: number }>();

  constructor() { }

  ngOnInit(): void {
  }

  onEditPassenger(passenger: IPassenger, passengerIndex: number): void {
    this.onEdit.emit({ passenger: passenger, passengerIndex: passengerIndex });
  }

  onDeletePassenger(passengerIndex: number): void {
    this.onDelete.emit({ passengerIndex });
  }

}
