import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "../../../_service/page/page-height.service";

@Component({
  selector: 'sgc-user-list-page',
  templateUrl: './user-list-page.component.html',
  styleUrls: ['./user-list-page.component.scss']
})
export class UserListPageComponent implements OnInit {
  minHeight:number = 0;

  constructor(private pageHeightService:PageHeightService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
  }
}
