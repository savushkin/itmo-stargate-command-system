import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PageEvent} from '@angular/material';
import 'rxjs/add/operator/map'
import {ListComponent} from "@sgc/_component/common/list/list.component";
import {CommandListService} from "@sgc/_service/command/command-list.service";
import {Command} from "@sgc/_model/command";

@Component({
  selector: 'sgc-command-list',
  templateUrl: './command-list.component.html',
  styleUrls: ['./command-list.component.scss']
})
export class CommandListComponent
  extends ListComponent<Command, CommandListService>
  implements OnInit {

  constructor(route: ActivatedRoute,
              router: Router,
              commandListService: CommandListService) {
    super(route, router);
    this.dataSource = commandListService;
    this.pageIndexParamName = 'command_page';
    this.pageSizeParamName = 'command_size';
  }

  ngOnInit() {
    super.ngOnInit();

    this.columns = ['number', 'members'];

    this.pagination.page.subscribe(
      (event: PageEvent) => {
        this.dataSource.getPage(event.pageIndex, event.pageSize);
      });
    this.dataSource.getPage(this.pageIndex, this.pageSize);
  }

}
