import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {AuthService} from "@sgc/_service/user/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PageComponent} from "@sgc/_component/page/page/page.component";

@Component({
  selector: 'sgc-logout-page',
  templateUrl: './logout-page.component.html',
  styleUrls: ['./logout-page.component.scss']
})
export class LogoutPageComponent extends PageComponent implements OnInit {

  constructor(
    route: ActivatedRoute,
    router: Router,
    pageHeightService: PageHeightService,
    authService: AuthService) {
    super(route, router, pageHeightService, authService);
  }


  ngOnInit() {
    super.ngOnInit();
    this.authService.logout(() => {
      this.router.navigate(['/login']);
    });
  }

}
