import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZoneEditPageComponent } from './zone-edit-page.component';

describe('ZoneEditPageComponent', () => {
  let component: ZoneEditPageComponent;
  let fixture: ComponentFixture<ZoneEditPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZoneEditPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZoneEditPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
