import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnyadirCiudadComponent } from './anyadir-ciudad.component';

describe('AnyadirCiudadComponent', () => {
  let component: AnyadirCiudadComponent;
  let fixture: ComponentFixture<AnyadirCiudadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnyadirCiudadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnyadirCiudadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
