import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { IPassenger } from 'src/app/models/IPassenger';

import { PassengerService } from 'src/app/services/passenger/passenger.service';

@Component({
  selector: 'app-passenger-table',
  templateUrl: './passenger-table.component.html',
  styleUrls: ['./passenger-table.component.scss']
})
export class PassengerTableComponent implements OnInit {
  @Input() passengers: IPassenger[] = [];
  @Output() onEditPreview = new EventEmitter<{ passenger: IPassenger, passengerIndex: number }>();

  constructor(private passengerService: PassengerService, private router: Router) { }

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

  onDetail(passengerId: number): void {
    this.router.navigateByUrl(`/dashboard/passengers/${passengerId}`);
  }
}
