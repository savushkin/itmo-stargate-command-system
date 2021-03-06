import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PageEvent} from '@angular/material';
import 'rxjs/add/operator/map'
import {ListComponent} from "@sgc/_component/common/list/list.component";
import {CommandListService} from "@sgc/_service/command/command-list.service";
import {User} from "@sgc/_model/user";
import {Zone} from "@sgc/_model/zone";
import {ZoneListService} from "@sgc/_service/zone/zone-list.service";
import {ZoneService} from "@sgc/_service/zone/zone.service";

@Component({
  selector: 'sgc-zone-list',
  templateUrl: './zone-list.component.html',
  styleUrls: ['./zone-list.component.scss']
})
export class ZoneListComponent
  extends ListComponent<Zone, ZoneListService>
  implements OnInit {
  private zoneService: ZoneService;

  constructor(route: ActivatedRoute,
              router: Router,
              zoneListService: ZoneListService,
              zoneService: ZoneService) {
    super(route, router);
    this.dataSource = zoneListService;
    this.zoneService = zoneService;
    this.pageIndexParamName = 'zone_page';
    this.pageSizeParamName = 'zone_size';
    this.pageSize = 5;
  }

  ngOnInit() {
    super.ngOnInit();
    this.columns = ['id', 'zone', 'climate', 'minerals', 'mititaryThreats', 'glyphs', 'icon-edit', 'icon-delete'];

    this.pagination.page.subscribe(
      (event: PageEvent) => {
        this.dataSource.getPage(event.pageIndex, event.pageSize);
      });
    this.dataSource.getPage(this.pageIndex, this.pageSize);
  }

  delete(zone) {
    if (zone)
      this.zoneService.deleteOne(zone.id).subscribe(
        resp => {
          this.dataSource.getPage(this.pageIndex, this.pageSize);
        },
        error => {

        },
        () => {

        }
      );

  }
}
