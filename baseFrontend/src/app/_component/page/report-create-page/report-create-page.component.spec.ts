import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportCreatePageComponent } from './report-create-page.component';

describe('ReportCreatePageComponent', () => {
  let component: ReportCreatePageComponent;
  let fixture: ComponentFixture<ReportCreatePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportCreatePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportCreatePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
