import { Injectable } from '@angular/core';

@Injectable()
export class GlyphService {
  private context:string = './assets/glyph/';
  public avalybleGlyphs:string[] = [
    'Earth',
    'Crater',
    'Virgo',
    'Bootes',
    'Centaurus',
    'Libra',
    'Serpens Caput',
    'Norma',
    'Scorpio',
    'Cra',
    'Scutum',
    'Sagittarius',
    'Aquila',
    'Mic',
    'Capricorn',
    'Pisces Austrinus',
    'Equuleus',
    'Aquarius',
    'Pegasus',
    'Sculptor',
    'Pisces',
    'Andromeda',
    'Triangulum',
    'Aries',
    'Perseus',
    'Cetus',
    'Taurus',
    'Auriga',
    'Eridanus',
    'Orion',
    'Canis Minor',
    'Monoceros',
    'Gemini',
    'Hydra',
    'Lynx',
    'Cancer',
    'Sextans',
    'Leo Minor',
    'Leo'
  ];
  public glyphs:any[] = [
    {
      url: this.context + 'glyph01.gif',
      name: 'Earth'
    },
    {
      url: this.context + 'glyph02.gif',
      name: 'Crater'
    },
    {
      url: this.context + 'glyph03.gif',
      name: 'Virgo'
    },
    {
      url: this.context + 'glyph04.gif',
      name: 'Bootes'
    },
    {
      url: this.context + 'glyph05.gif',
      name: 'Centaurus'
    },
    {
      url: this.context + 'glyph06.gif',
      name: 'Libra'
    },
    {
      url: this.context + 'glyph07.gif',
      name: 'Serpens Caput'
    },
    {
      url: this.context + 'glyph08.gif',
      name: 'Norma'
    },
    {
      url: this.context + 'glyph09.gif',
      name: 'Scorpio'
    },
    {
      url: this.context + 'glyph10.gif',
      name: 'Cra'
    },
    {
      url: this.context + 'glyph11.gif',
      name: 'Scutum'
    },
    {
      url: this.context + 'glyph12.gif',
      name: 'Sagittarius'
    },
    {
      url: this.context + 'glyph13.gif',
      name: 'Aquila'
    },
    {
      url: this.context + 'glyph14.gif',
      name: 'Mic'
    },
    {
      url: this.context + 'glyph15.gif',
      name: 'Capricorn'
    },
    {
      url: this.context + 'glyph16.gif',
      name: 'Pisces Austrinus'
    },
    {
      url: this.context + 'glyph17.gif',
      name: 'Equuleus'
    },
    {
      url: this.context + 'glyph18.gif',
      name: 'Aquarius'
    },
    {
      url: this.context + 'glyph19.gif',
      name: 'Pegasus'
    },
    {
      url: this.context + 'glyph20.gif',
      name: 'Sculptor'
    },
    {
      url: this.context + 'glyph21.gif',
      name: 'Pisces'
    },
    {
      url: this.context + 'glyph22.gif',
      name: 'Andromeda'
    },
    {
      url: this.context + 'glyph23.gif',
      name: 'Triangulum'
    },
    {
      url: this.context + 'glyph24.gif',
      name: 'Aries'
    },
    {
      url: this.context + 'glyph25.gif',
      name: 'Perseus'
    },
    {
      url: this.context + 'glyph26.gif',
      name: 'Cetus'
    },
    {
      url: this.context + 'glyph27.gif',
      name: 'Taurus'
    },
    {
      url: this.context + 'glyph28.gif',
      name: 'Auriga'
    },
    {
      url: this.context + 'glyph29.gif',
      name: 'Eridanus'
    },
    {
      url: this.context + 'glyph30.gif',
      name: 'Orion'
    },
    {
      url: this.context + 'glyph31.gif',
      name: 'Canis Minor'
    },
    {
      url: this.context + 'glyph32.gif',
      name: 'Monoceros'
    },
    {
      url: this.context + 'glyph33.gif',
      name: 'Gemini'
    },
    {
      url: this.context + 'glyph34.gif',
      name: 'Hydra'
    },
    {
      url: this.context + 'glyph35.gif',
      name: 'Lynx'
    },
    {
      url: this.context + 'glyph36.gif',
      name: 'Cancer'
    },
    {
      url: this.context + 'glyph37.gif',
      name: 'Sextans'
    },
    {
      url: this.context + 'glyph38.gif',
      name: 'Leo Minor'
    },
    {
      url: this.context + 'glyph39.gif',
      name: 'Leo'
    },
  ];

  constructor() { }

}
