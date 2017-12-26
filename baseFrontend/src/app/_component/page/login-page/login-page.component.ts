import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PageComponent} from "@sgc/_component/page/page/page.component";
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {AuthService} from "@sgc/_service/user/auth.service";

@Component({
  selector: 'sgc-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent extends PageComponent implements OnInit {
  username = null;
  password = null;

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

  login() {
    this.authService.login(this.username, this.password, () => {
      this.router.navigate(['/profile']);
    });
  }

}
