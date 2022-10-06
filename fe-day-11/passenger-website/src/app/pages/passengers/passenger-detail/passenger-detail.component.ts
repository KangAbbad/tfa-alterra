import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IPassenger } from 'src/app/models/IPassenger';
import { PassengerService } from 'src/app/services/passenger.service';

@Component({
  selector: 'app-passenger-detail',
  templateUrl: './passenger-detail.component.html',
})
export class PassengerDetailComponent implements OnInit {
  paramsId: number | null = null;

  constructor(private passengerService: PassengerService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.paramsId = params['id'];
    });
  }

  getData(): IPassenger {
    return this.passengerService.getPassengers().find((passenger) => passenger.id === this.paramsId) as IPassenger;
  }
}
