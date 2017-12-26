import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {AuthService} from "@sgc/_service/user/auth.service";
import {PageComponent} from "../page/page.component";
import {ActivatedRoute, Route, Router} from "@angular/router";

@Component({
  selector: 'sgc-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.scss']
})
export class ProfilePageComponent extends PageComponent implements OnInit {

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
