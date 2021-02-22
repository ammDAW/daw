import { TestBed } from '@angular/core/testing';

import { ConsultarTiempoService } from './consultar-tiempo.service';

describe('ConsultarTiempoService', () => {
  let service: ConsultarTiempoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsultarTiempoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
