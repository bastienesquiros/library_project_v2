import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrarianSideComponent } from './librarian-side.component';

describe('LibrarianSideComponent', () => {
  let component: LibrarianSideComponent;
  let fixture: ComponentFixture<LibrarianSideComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LibrarianSideComponent]
    });
    fixture = TestBed.createComponent(LibrarianSideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
