import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "../../../_service/page/page-height.service";

@Component({
  selector: 'sgc-zone-page',
  templateUrl: './zone-page.component.html',
  styleUrls: ['./zone-page.component.scss']
})
export class ZonePageComponent implements OnInit {
  minHeight:number = 0;

  constructor(private pageHeightService:PageHeightService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
  }
}
