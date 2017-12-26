import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";

@Component({
  selector: 'sgc-address-list-page',
  templateUrl: './address-list-page.component.html',
  styleUrls: ['./address-list-page.component.scss']
})
export class AddressListPageComponent implements OnInit {
  minHeight:number = 0;
  addresses:any[] = [
    {
      title: 'ABYDOS',
      description: 'Original destination',
      glyphs: [27,7,15,32,12,30]
    },
    {
      title: 'PX1-767',
      description: 'Camelot',
      glyphs: [20,2,35,8,26,15]
    },
    {
      title: 'CHULAK',
      description: 'Jaffa homeworld',
      glyphs: [9,2,23,15,37,20]
    },
    {
      title: 'EARTH',
      description: 'The SGC Stargate',
      glyphs: [28,26,5,36,11,29]
    },
    {
      title: 'OTHALA',
      description: 'Asgard homeworld',
      glyphs: [11,27,23,16,33,3,9]
    },
    {
      title: 'P34-353J',
      description: 'Desert Tok\'ra base',
      glyphs: [38,9,28,15,35,3]
    },
    {
      title: 'P3X-984',
      description: 'Alpha / Beta Site',
      glyphs: [29,5,36,6,26,8]
    },
    {
      title: 'TOLLAN',
      description: 'Destroyed homeworld',
      glyphs: [4,29,8,22,18,25]
    },
    {
      title: 'TOLLANA',
      description: 'New homeworld',
      glyphs: [4,29,8,22,18,25]
    }
  ];

  constructor(private pageHeightService:PageHeightService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
  }
}
