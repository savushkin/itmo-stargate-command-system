import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";

@Component({
  selector: 'sgc-base-list-page',
  templateUrl: './base-list-page.component.html',
  styleUrls: ['./base-list-page.component.scss']
})
export class BaseListPageComponent implements OnInit {
  minHeight:number = 0;
  planets:any[] = [
    this.addRandomZone(),
    this.addRandomZone(),
    this.addRandomZone()
  ];

  constructor(private pageHeightService:PageHeightService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
  }

  addRandomZone() {
    let address = [];

    while (address.length < 6) {
      let glyph = Math.round(Math.random()*39);
      if (address.indexOf(glyph) === -1)
        address.push(glyph)
    }

    return {
      title: 'База Альфа',
      planet: `PX${Math.round(Math.random()*9)}-${Math.round(Math.random()*1000)}`,
      description: '',
      glyphs: address,
    }
  }
}
