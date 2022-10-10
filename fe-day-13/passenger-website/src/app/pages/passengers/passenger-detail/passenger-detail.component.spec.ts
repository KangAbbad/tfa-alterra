import { RouterTestingModule } from '@angular/router/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { PassengerService } from 'src/app/services/passenger/passenger.service';
import { PassengerDetailComponent } from './passenger-detail.component';
import { By } from '@angular/platform-browser';

describe('PassengerDetailComponent', () => {
  let component: PassengerDetailComponent;
  let fixture: ComponentFixture<PassengerDetailComponent>;
  let passengerService: jasmine.SpyObj<PassengerService>;

  const mockPassengerData = [{ id: 1, name: 'kangabbad', city: 'Solo' }];

  beforeEach(async () => {
    passengerService = jasmine.createSpyObj('PassengerService', ['getPassengers']);
    passengerService.getPassengers.and.returnValue(mockPassengerData);

    await TestBed.configureTestingModule({
      declarations: [ PassengerDetailComponent ],
      imports: [RouterTestingModule],
      providers: [
        PassengerService,
        {
          provide: ActivatedRoute,
          useValue: {
            params: of({
              id: 1
            }),
          }
        },
        {
          provide: PassengerService,
          useValue: passengerService,
        },
      ],
    })
    .compileComponents();

    fixture = TestBed.createComponent(PassengerDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('should url params is 1', () => {
    const activatedRoute: ActivatedRoute = fixture.debugElement.injector.get(ActivatedRoute);
    activatedRoute.params.subscribe((value) => {
      expect(value).toEqual({ id: 1 });
    });
  });

  it('should return passenger data', () => {
    component.paramsId = 1;
    expect(component.getData()).toEqual(mockPassengerData[0]);
  });

  it('should show passenger ID', () => {
    const h5Elms = fixture.debugElement.queryAll(By.css('h5'));
    const idElm = h5Elms[0].nativeElement.innerHTML;
    expect(idElm).toEqual('ID: 1');
  });

  it('should show passenger name', () => {
    const h5Elms = fixture.debugElement.queryAll(By.css('h5'));
    const nameElm = h5Elms[1].nativeElement.innerHTML;
    expect(nameElm).toEqual('Nama: kangabbad');
  });

  it('should show passenger name', () => {
    const h5Elms = fixture.debugElement.queryAll(By.css('h5'));
    const cityElm = h5Elms[2].nativeElement.innerHTML;
    expect(cityElm).toEqual('Kota: Solo');
  });
});
