import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscriberSideComponent } from './subscriber-side.component';

describe('SubscriberSideComponent', () => {
  let component: SubscriberSideComponent;
  let fixture: ComponentFixture<SubscriberSideComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SubscriberSideComponent]
    });
    fixture = TestBed.createComponent(SubscriberSideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
