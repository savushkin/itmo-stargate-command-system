import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MissionListPageComponent } from './mission-list-page.component';

describe('MissionListPageComponent', () => {
  let component: MissionListPageComponent;
  let fixture: ComponentFixture<MissionListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MissionListPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MissionListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
