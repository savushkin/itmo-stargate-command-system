import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {PageHeightService} from "./_service/page/page-height.service";

@Component({
  selector: 'sgc-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  minHeight:number = 0;

  @ViewChild("wrapper")
  private divWrapper:ElementRef;
  @ViewChild("toolbar")
  private divToolbar:ElementRef;
  @ViewChild("sidenavContainer")
  private divSidenavContainer:ElementRef;

  constructor(private pageHeightService:PageHeightService) {

  }

  ngOnInit(): void {
    this.minHeight = this.divWrapper.nativeElement.offsetHeight - this.divToolbar.nativeElement.offsetHeight - 27;
    this.pageHeightService.height.next(this.minHeight);
  }

}
