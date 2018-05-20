import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {PageComponent} from "@sgc/_component/page/page/page.component";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "@sgc/_service/user/auth.service";

@Component({
  selector: 'sgc-user-edit-page',
  templateUrl: './user-edit-page.component.html',
  styleUrls: ['./user-edit-page.component.scss']
})
export class UserEditPageComponent extends PageComponent implements OnInit {

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
