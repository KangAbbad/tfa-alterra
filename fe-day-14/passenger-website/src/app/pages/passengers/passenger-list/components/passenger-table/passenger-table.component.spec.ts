import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengerTableComponent } from './passenger-table.component';
import { PassengerService } from 'src/app/services/passenger/passenger.service';

describe('PassengerTableComponent', () => {
  let component: PassengerTableComponent;
  let fixture: ComponentFixture<PassengerTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassengerTableComponent ],
      providers: [PassengerService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PassengerTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
