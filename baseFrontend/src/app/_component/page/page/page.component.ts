import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {AuthService} from "@sgc/_service/user/auth.service";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {User} from "@sgc/_model/user";

@Component({
  selector: 'sgc-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.scss']
})
export class PageComponent implements OnInit {
  minHeight:number = 0;
  user: User;

  route: ActivatedRoute;
  router: Router;
  pageHeightService: PageHeightService;
  authService: AuthService;

  constructor(
    route: ActivatedRoute,
    router: Router,
    pageHeightService: PageHeightService,
    authService: AuthService) {
    this.route = route;
    this.router = router;
    this.pageHeightService = pageHeightService;
    this.authService = authService;
  }

  ngOnInit() {
    this.minHeight = this.pageHeightService.height.getValue();
    this.authService.user.subscribe(user => this.user = user)

  }

}
