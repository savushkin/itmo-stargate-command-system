import { Injectable } from '@angular/core';

@Injectable()
export class GlyphService {
  private context:string = '/assets/glyph/';

  public glyphs:any[] = [
    {
      id: 1,
      url: this.context + 'glyph01.gif',
      name: 'Earth'
    },
    {
      id: 2,
      url: this.context + 'glyph02.gif',
      name: 'Crater'
    },
    {
      id: 3,
      url: this.context + 'glyph03.gif',
      name: 'Virgo'
    },
    {
      id: 4,
      url: this.context + 'glyph04.gif',
      name: 'Bootes'
    },
    {
      id: 5,
      url: this.context + 'glyph05.gif',
      name: 'Centaurus'
    },
    {
      id: 6,
      url: this.context + 'glyph06.gif',
      name: 'Libra'
    },
    {
      id: 7,
      url: this.context + 'glyph07.gif',
      name: 'Serpens Caput'
    },
    {
      id: 8,
      url: this.context + 'glyph08.gif',
      name: 'Norma'
    },
    {
      id: 9,
      url: this.context + 'glyph09.gif',
      name: 'Scorpio'
    },
    {
      id: 10,
      url: this.context + 'glyph10.gif',
      name: 'Cra'
    },
    {
      id: 11,
      url: this.context + 'glyph11.gif',
      name: 'Scutum'
    },
    {
      id: 12,
      url: this.context + 'glyph12.gif',
      name: 'Sagittarius'
    },
    {
      id: 13,
      url: this.context + 'glyph13.gif',
      name: 'Aquila'
    },
    {
      id: 14,
      url: this.context + 'glyph14.gif',
      name: 'Mic'
    },
    {
      id: 15,
      url: this.context + 'glyph15.gif',
      name: 'Capricorn'
    },
    {
      id: 16,
      url: this.context + 'glyph16.gif',
      name: 'Pisces Austrinus'
    },
    {
      id: 17,
      url: this.context + 'glyph17.gif',
      name: 'Equuleus'
    },
    {
      id: 18,
      url: this.context + 'glyph18.gif',
      name: 'Aquarius'
    },
    {
      id: 19,
      url: this.context + 'glyph19.gif',
      name: 'Pegasus'
    },
    {
      id: 20,
      url: this.context + 'glyph20.gif',
      name: 'Sculptor'
    },
    {
      id: 21,
      url: this.context + 'glyph21.gif',
      name: 'Pisces'
    },
    {
      id: 22,
      url: this.context + 'glyph22.gif',
      name: 'Andromeda'
    },
    {
      id: 23,
      url: this.context + 'glyph23.gif',
      name: 'Triangulum'
    },
    {
      id: 24,
      url: this.context + 'glyph24.gif',
      name: 'Aries'
    },
    {
      id: 25,
      url: this.context + 'glyph25.gif',
      name: 'Perseus'
    },
    {
      id: 26,
      url: this.context + 'glyph26.gif',
      name: 'Cetus'
    },
    {
      id: 27,
      url: this.context + 'glyph27.gif',
      name: 'Taurus'
    },
    {
      id: 28,
      url: this.context + 'glyph28.gif',
      name: 'Auriga'
    },
    {
      id: 29,
      url: this.context + 'glyph29.gif',
      name: 'Eridanus'
    },
    {
      id: 30,
      url: this.context + 'glyph30.gif',
      name: 'Orion'
    },
    {
      id: 31,
      url: this.context + 'glyph31.gif',
      name: 'Canis Minor'
    },
    {
      id: 32,
      url: this.context + 'glyph32.gif',
      name: 'Monoceros'
    },
    {
      id: 33,
      url: this.context + 'glyph33.gif',
      name: 'Gemini'
    },
    {
      id: 34,
      url: this.context + 'glyph34.gif',
      name: 'Hydra'
    },
    {
      id: 35,
      url: this.context + 'glyph35.gif',
      name: 'Lynx'
    },
    {
      id: 36,
      url: this.context + 'glyph36.gif',
      name: 'Cancer'
    },
    {
      id: 37,
      url: this.context + 'glyph37.gif',
      name: 'Sextans'
    },
    {
      id: 38,
      url: this.context + 'glyph38.gif',
      name: 'Leo Minor'
    },
    {
      id: 39,
      url: this.context + 'glyph39.gif',
      name: 'Leo'
    },
  ];

  constructor() { }

}
