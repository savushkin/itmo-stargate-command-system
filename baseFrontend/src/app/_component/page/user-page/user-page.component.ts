import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "../../../_service/page/page-height.service";

@Component({
  selector: 'sgc-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.scss']
})
export class UserPageComponent implements OnInit {
  minHeight:number = 0;

  constructor(private pageHeightService:PageHeightService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
  }
}
