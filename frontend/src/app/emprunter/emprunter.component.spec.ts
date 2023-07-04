import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmprunterComponent } from './emprunter.component';

describe('EmprunterComponent', () => {
  let component: EmprunterComponent;
  let fixture: ComponentFixture<EmprunterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmprunterComponent]
    });
    fixture = TestBed.createComponent(EmprunterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
