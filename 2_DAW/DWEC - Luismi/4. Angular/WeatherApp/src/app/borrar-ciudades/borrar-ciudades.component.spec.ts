import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrarCiudadesComponent } from './borrar-ciudades.component';

describe('BorrarCiudadesComponent', () => {
  let component: BorrarCiudadesComponent;
  let fixture: ComponentFixture<BorrarCiudadesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BorrarCiudadesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrarCiudadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
