import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbonneComponent } from './abonne.component';

describe('AbonneComponent', () => {
  let component: AbonneComponent;
  let fixture: ComponentFixture<AbonneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AbonneComponent]
    });
    fixture = TestBed.createComponent(AbonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
