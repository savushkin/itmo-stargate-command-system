import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "../../../_service/page/page-height.service";

@Component({
  selector: 'sgc-zone-create-page',
  templateUrl: './zone-create-page.component.html',
  styleUrls: ['./zone-create-page.component.scss']
})
export class ZoneCreatePageComponent implements OnInit {
  minHeight:number = 0;

  constructor(private pageHeightService:PageHeightService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
  }
}
