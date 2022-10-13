import { TestBed } from "@angular/core/testing";

import { PassengersModule } from "./passengers.module";

describe('PassengersModule', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [PassengersModule],
    });
  });

  it('initializes', () => {
    const module = TestBed.inject(PassengersModule);
    expect(module).toBeTruthy();
  });
});