import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PageEvent} from '@angular/material';
import 'rxjs/add/operator/map'
import {ListComponent} from "@sgc/_component/common/list/list.component";
import {Mission} from "@sgc/_model/mission";
import {MissionListService} from "@sgc/_service/mission/mission-list.service";

@Component({
  selector: 'sgc-mission-list',
  templateUrl: './mission-list.component.html',
  styleUrls: ['./mission-list.component.scss']
})
export class MissionListComponent
  extends ListComponent<Mission, MissionListService>
  implements OnInit {

  constructor(route: ActivatedRoute,
              router: Router,
              missionListService: MissionListService) {
    super(route, router);
    this.dataSource = missionListService;
    this.pageIndexParamName = 'mission_page';
    this.pageSizeParamName = 'mission_size';
  }

  ngOnInit() {
    super.ngOnInit();

    this.columns = ['id', 'zone', 'command', 'date'];

    this.pagination.page.subscribe(
      (event: PageEvent) => {
        this.dataSource.getPage(event.pageIndex, event.pageSize);
      });
    this.dataSource.getPage(this.pageIndex, this.pageSize);
  }

}
