import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisCiudadesComponent } from './mis-ciudades.component';

describe('MisCiudadesComponent', () => {
  let component: MisCiudadesComponent;
  let fixture: ComponentFixture<MisCiudadesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MisCiudadesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MisCiudadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
