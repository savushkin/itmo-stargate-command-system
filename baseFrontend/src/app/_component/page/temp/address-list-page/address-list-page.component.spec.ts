import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddressListPageComponent } from './address-list-page.component';

describe('AddressListPageComponent', () => {
  let component: AddressListPageComponent;
  let fixture: ComponentFixture<AddressListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddressListPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddressListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
