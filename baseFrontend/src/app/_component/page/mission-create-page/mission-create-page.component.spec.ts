import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MissionCreatePageComponent } from './mission-create-page.component';

describe('MissionCreatePageComponent', () => {
  let component: MissionCreatePageComponent;
  let fixture: ComponentFixture<MissionCreatePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MissionCreatePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MissionCreatePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
