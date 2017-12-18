import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "../../../_service/page/page-height.service";

@Component({
  selector: 'sgc-report-list-page',
  templateUrl: './report-list-page.component.html',
  styleUrls: ['./report-list-page.component.scss']
})
export class ReportListPageComponent implements OnInit {
  minHeight:number = 0;
  reports:any[] = [
    {
      date: new Date
    },
    {
      date: new Date
    },
    {
      date: new Date
    },
    {
      date: new Date
    }
  ];

  constructor(private pageHeightService:PageHeightService) { }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
  }
}
