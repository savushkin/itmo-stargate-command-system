import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddressCreatePageComponent } from './address-create-page.component';

describe('AddressCreatePageComponent', () => {
  let component: AddressCreatePageComponent;
  let fixture: ComponentFixture<AddressCreatePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddressCreatePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddressCreatePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
