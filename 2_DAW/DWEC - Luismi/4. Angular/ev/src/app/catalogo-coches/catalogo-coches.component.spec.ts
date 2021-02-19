import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatalogoCochesComponent } from './catalogo-coches.component';

describe('CatalogoCochesComponent', () => {
  let component: CatalogoCochesComponent;
  let fixture: ComponentFixture<CatalogoCochesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CatalogoCochesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CatalogoCochesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
