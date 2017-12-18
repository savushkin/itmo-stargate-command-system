import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "../../../_service/page/page-height.service";

@Component({
  selector: 'sgc-mission-create-page',
  templateUrl: './mission-create-page.component.html',
  styleUrls: ['./mission-create-page.component.scss']
})
export class MissionCreatePageComponent implements OnInit {
  minHeight:number = 0;
  planet:any = this.addRandomZone();

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
