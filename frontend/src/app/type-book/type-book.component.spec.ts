import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeBookComponent } from './type-book.component';

describe('TypeBookComponent', () => {
  let component: TypeBookComponent;
  let fixture: ComponentFixture<TypeBookComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TypeBookComponent]
    });
    fixture = TestBed.createComponent(TypeBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
