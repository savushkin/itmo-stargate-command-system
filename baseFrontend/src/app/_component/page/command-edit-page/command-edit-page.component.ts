import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {PageComponent} from "@sgc/_component/page/page/page.component";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "@sgc/_service/user/auth.service";
import {Command} from "@sgc/_model/command";

@Component({
  selector: 'sgc-command-create-page',
  templateUrl: './command-edit-page.component.html',
  styleUrls: ['./command-edit-page.component.scss']
})
export class CommandEditPageComponent extends PageComponent implements OnInit {

  public command: Command = null;
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
        if (data['command'])
          this.command = data['command'];
        else
          this.command = null;
      }
    )
  }

}
