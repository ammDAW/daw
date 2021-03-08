import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscadorConsultasComponent } from './buscador-consultas.component';

describe('BuscadorConsultasComponent', () => {
  let component: BuscadorConsultasComponent;
  let fixture: ComponentFixture<BuscadorConsultasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuscadorConsultasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuscadorConsultasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
