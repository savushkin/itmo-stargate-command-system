import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {GlyphService} from "@sgc/_service/stargate/glyph.service";

@Component({
  selector: 'sgc-address-create-page',
  templateUrl: './address-create-page.component.html',
  styleUrls: ['./address-create-page.component.scss']
})
export class AddressCreatePageComponent implements OnInit {
  minHeight:number = 0;
  availableGlyphs:string[] = [];
  address:string[] = [];

  constructor(private pageHeightService:PageHeightService,
              private glyphService:GlyphService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
    this.availableGlyphs = this.glyphService.avalybleGlyphs;
  }

  addGlyph(name:string) {
    if (this.address.length < 8 && this.address.indexOf(name) === -1) {
      this.address.push(name);
    }
  }
}
