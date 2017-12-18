import { TestBed, inject } from '@angular/core/testing';

import { GlyphService } from './glyph.service';

describe('GlyphService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GlyphService]
    });
  });

  it('should be created', inject([GlyphService], (service: GlyphService) => {
    expect(service).toBeTruthy();
  }));
});
