import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PageEvent} from '@angular/material';
import 'rxjs/add/operator/map'
import {ListComponent} from "@sgc/_component/common/list/list.component";
import {Mission} from "@sgc/_model/mission";
import {MissionListService} from "@sgc/_service/mission/mission-list.service";
import {MissionService} from "@sgc/_service/mission/mission.service";

@Component({
  selector: 'sgc-mission-list',
  templateUrl: './mission-list.component.html',
  styleUrls: ['./mission-list.component.scss']
})
export class MissionListComponent
  extends ListComponent<Mission, MissionListService>
  implements OnInit {
  private missionService: MissionService;

  constructor(route: ActivatedRoute,
              router: Router,
              missionListService: MissionListService,
              missionService: MissionService) {
    super(route, router);
    this.dataSource = missionListService;
    this.pageSize = 5;
    this.pageIndexParamName = 'mission_page';
    this.pageSizeParamName = 'mission_size';

    this.missionService = missionService;
  }

  ngOnInit() {
    super.ngOnInit();

    this.columns = ['id', 'name', 'zone', 'command', 'dateDeparture', 'description', 'icon-approve', 'icon-cancel', 'icon-edit', 'icon-delete'];

    this.pagination.page.subscribe(
      (event: PageEvent) => {
        this.dataSource.getPage(event.pageIndex, event.pageSize);
      });
    this.dataSource.getPage(this.pageIndex, this.pageSize);
  }

  approveMission(mission) {
    this.missionService.approve(mission.id).subscribe(
      resp =>  this.dataSource.getPage(this.pageIndex, this.pageSize)
    )
  }

  cancelMission(mission) {
    this.missionService.cancel(mission.id).subscribe(
      resp =>  this.dataSource.getPage(this.pageIndex, this.pageSize)
    )
  }

  delete(mission) {
    this.missionService.delete(mission.id).subscribe(
      resp =>  {
        this.pageIndex = 0;
        this.dataSource.getPage(this.pageIndex, this.pageSize)
      }
    )
  }

}
