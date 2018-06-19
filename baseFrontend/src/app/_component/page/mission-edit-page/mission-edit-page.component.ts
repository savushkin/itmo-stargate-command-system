import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {PageComponent} from "@sgc/_component/page/page/page.component";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "@sgc/_service/user/auth.service";
import {Mission} from "@sgc/_model/mission";

@Component({
  selector: 'sgc-mission-edit-page',
  templateUrl: './mission-edit-page.component.html',
  styleUrls: ['./mission-edit-page.component.scss']
})
export class MissionEditPageComponent extends PageComponent implements OnInit {

  public mission: Mission = null;
  constructor(
    route: ActivatedRoute,
    router: Router,
    pageHeightService: PageHeightService,
    authService: AuthService) {
    super(route, router, pageHeightService, authService);
  }

  ngOnInit() {
    super.ngOnInit();
    this.route.data.subscribe(
      data => {
        if (data['mission'])
          this.mission = data['mission'];
        else
          this.mission = null;
      }
    )
  }

}
