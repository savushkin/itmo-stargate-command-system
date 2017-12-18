import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZoneListPageComponent } from './zone-list-page.component';

describe('ZoneListPageComponent', () => {
  let component: ZoneListPageComponent;
  let fixture: ComponentFixture<ZoneListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZoneListPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZoneListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
