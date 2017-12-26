import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewEncapsulation} from '@angular/core';
import {GlyphService} from "../../../_service/stargate/glyph.service";

@Component({
  selector: 'sgc-glyph',
  templateUrl: './glyph.component.html',
  styleUrls: ['./glyph.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class GlyphComponent implements OnInit, OnChanges {

  @Input()
  name:string = null;
  @Input()
  id:number = null;
  url = null;

  constructor(private glyphService:GlyphService) { }

  ngOnInit() {

  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.name !== null && 'name' in changes) {
      let glyph = this.glyphService.glyphs.filter(glyph => glyph.name === this.name)[0];
      if (glyph)
        this.url = glyph.url;
    }
    if (this.id !== null && 'id' in changes) {
      let glyph = this.glyphService.glyphs[this.id-1];
      if (glyph) {
        this.name = glyph.name;
        this.url = glyph.url;
      }
    }
  }

}
