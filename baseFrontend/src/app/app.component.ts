import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {PageHeightService} from "./_service/page/page-height.service";
import {AuthService} from "./_service/user/auth.service";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {SidenavService} from "./_service/page/sidenav.service";
import {MatSidenav} from "@angular/material";

@Component({
  selector: 'sgc-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  minHeight:number = 0;
  user = null;
  sidenavLinks = [];

  @ViewChild(MatSidenav)
  sidenav: MatSidenav;

  @ViewChild("wrapper")
  private divWrapper:ElementRef;
  @ViewChild("toolbar")
  private divToolbar:ElementRef;
  @ViewChild("sidenavContainer")
  private divSidenavContainer:ElementRef;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private sidenavService: SidenavService,
    private pageHeightService:PageHeightService,
    private authService:AuthService) {

  }

  ngOnInit(): void {
    this.minHeight = this.divWrapper.nativeElement.offsetHeight - this.divToolbar.nativeElement.offsetHeight - 27;
    this.pageHeightService.height.next(this.minHeight);
    this.authService.user.subscribe(user => this.user = user);
    this.router.events
      .subscribe((event) => {
        if (event instanceof NavigationEnd) {
          this.sidenavService.pageChanged(event.url);
        }
      });
    this.sidenavService.links.subscribe(
      links =>  {
        this.sidenavLinks = links;
      }
    );
  }

}
