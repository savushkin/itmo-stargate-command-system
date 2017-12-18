import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StargatePageComponent } from './stargate-page.component';

describe('StargatePageComponent', () => {
  let component: StargatePageComponent;
  let fixture: ComponentFixture<StargatePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StargatePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StargatePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
