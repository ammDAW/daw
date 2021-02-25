import { TestBed } from '@angular/core/testing';

import { ListaCiudadesService } from './lista-ciudades.service';

describe('ListaCiudadesService', () => {
  let service: ListaCiudadesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaCiudadesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
