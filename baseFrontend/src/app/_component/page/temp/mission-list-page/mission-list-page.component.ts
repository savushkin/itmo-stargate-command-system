import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";

@Component({
  selector: 'sgc-mission-list-page',
  templateUrl: './mission-list-page.component.html',
  styleUrls: ['./mission-list-page.component.scss']
})
export class MissionListPageComponent implements OnInit {
  minHeight:number = 0;
  addresses:any[] = [
    this.addRandomZone(),
    this.addRandomZone(),
    this.addRandomZone(),
    this.addRandomZone(),
    this.addRandomZone(),
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
      title: `PX${Math.round(Math.random()*9)}-${Math.round(Math.random()*1000)}`,
      description: '',
      glyphs: address,
      squad: Math.round(Math.random()*2)
    }
  }
}
