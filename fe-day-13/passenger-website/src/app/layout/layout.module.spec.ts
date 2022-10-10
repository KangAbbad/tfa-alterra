import { TestBed } from "@angular/core/testing";

import { LayoutModule } from "./layout.module";

describe('LayoutModule', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [LayoutModule],
    });
  });

  it('initializes', () => {
    const module = TestBed.inject(LayoutModule);
    expect(module).toBeTruthy();
  });
});