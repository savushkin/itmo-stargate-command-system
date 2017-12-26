import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";

@Component({
  selector: 'sgc-address-page',
  templateUrl: './address-page.component.html',
  styleUrls: ['./address-page.component.scss']
})
export class AddressPageComponent implements OnInit {
  minHeight:number = 0;

  constructor(private pageHeightService:PageHeightService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
  }
}
