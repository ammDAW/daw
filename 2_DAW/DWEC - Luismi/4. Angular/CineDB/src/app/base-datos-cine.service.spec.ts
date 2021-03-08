import { TestBed } from '@angular/core/testing';

import { BaseDatosCineService } from './base-datos-cine.service';

describe('BaseDatosCineService', () => {
  let service: BaseDatosCineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BaseDatosCineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
