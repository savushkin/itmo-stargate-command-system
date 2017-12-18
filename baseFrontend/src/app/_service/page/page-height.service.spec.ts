import { TestBed, inject } from '@angular/core/testing';

import { PageHeightService } from './page-height.service';

describe('PageHeightService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PageHeightService]
    });
  });

  it('should be created', inject([PageHeightService], (service: PageHeightService) => {
    expect(service).toBeTruthy();
  }));
});
