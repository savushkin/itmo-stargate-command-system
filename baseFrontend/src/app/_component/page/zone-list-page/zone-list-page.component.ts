import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "app/_service/page/page-height.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "@sgc/_service/user/auth.service";
import {PageComponent} from "@sgc/_component/page/page/page.component";

@Component({
  selector: 'sgc-zone-list-page',
  templateUrl: './zone-list-page.component.html',
  styleUrls: ['./zone-list-page.component.scss']
})
export class ZoneListPageComponent extends PageComponent implements OnInit {

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
