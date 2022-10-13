import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';

import { PassengerService } from 'src/app/services/passenger/passenger.service';
import { PassengerFormComponent } from './components/passenger-form/passenger-form.component';
import { PassengerTableComponent } from './components/passenger-table/passenger-table.component';
import { PassengerListComponent } from './passenger-list.component';

describe('PassengerListComponent', () => {
  let component: PassengerListComponent;
  let fixture: ComponentFixture<PassengerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassengerListComponent, PassengerTableComponent, PassengerFormComponent ],
      imports: [ReactiveFormsModule],
      providers: [PassengerService],
    })
    .compileComponents();

    fixture = TestBed.createComponent(PassengerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
