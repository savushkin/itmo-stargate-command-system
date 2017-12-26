import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {PageComponent} from "@sgc/_component/page/page/page.component";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "@sgc/_service/user/auth.service";

@Component({
  selector: 'sgc-mission-list-page',
  templateUrl: './mission-list-page.component.html',
  styleUrls: ['./mission-list-page.component.scss']
})
export class MissionListPageComponent extends PageComponent implements OnInit {

  constructor(
    route: ActivatedRoute,
    router: Router,
    pageHeightService: PageHeightService,
    authService: AuthService) {
    super(route, router, pageHeightService, authService);
  }

  ngOnInit() {
    super.ngOnInit();
  }

}
