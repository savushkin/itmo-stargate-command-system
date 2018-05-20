import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PageEvent} from '@angular/material';
import 'rxjs/add/operator/map'
import {User} from "@sgc/_model/user";
import {UserListService} from "@sgc/_service/user/user-list.service";
import {ListComponent} from "@sgc/_component/common/list/list.component";

@Component({
  selector: 'sgc-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent
  extends ListComponent<User, UserListService>
  implements OnInit {

  constructor(route: ActivatedRoute,
              router: Router,
              userListService: UserListService) {
    super(route, router);
    this.dataSource = userListService;
    this.pageIndexParamName = 'user_page';
    this.pageSizeParamName = 'user_size';
  }

  ngOnInit() {
    super.ngOnInit();

    this.columns = ['id', 'username', 'name', 'surname', 'rank', 'roles', 'command', 'icon-edit'];

    this.pagination.page.subscribe(
      (event: PageEvent) => {
        this.dataSource.getPage(event.pageIndex, event.pageSize);
      });
    this.dataSource.getPage(this.pageIndex, this.pageSize);
  }

}
