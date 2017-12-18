import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZoneCreatePageComponent } from './zone-create-page.component';

describe('ZoneCreatePageComponent', () => {
  let component: ZoneCreatePageComponent;
  let fixture: ComponentFixture<ZoneCreatePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZoneCreatePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZoneCreatePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
