import {Component, OnInit} from '@angular/core';
import {PageHeightService} from "app/_service/page/page-height.service";
import {PageComponent} from "@sgc/_component/page/page/page.component";
import {Command} from "@sgc/_model/command";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "@sgc/_service/user/auth.service";
import {Zone} from "@sgc/_model/zone";

@Component({
  selector: 'sgc-zone-edit-page',
  templateUrl: './zone-edit-page.component.html',
  styleUrls: ['./zone-edit-page.component.scss']
})
export class ZoneEditPageComponent extends PageComponent implements OnInit {

  public zone: Zone = null;
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
        if (data['zone'])
          this.zone = data['zone'];
        else
          this.zone = null;
      }
    )
  }

}
