import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PageEvent} from '@angular/material';
import 'rxjs/add/operator/map'
import {User} from "@sgc/_model/user";
import {UserListService} from "@sgc/_service/user/user-list.service";
import {ListComponent} from "@sgc/_component/common/list/list.component";
import {UserService} from "@sgc/_service/user/user.service";

@Component({
  selector: 'sgc-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent
  extends ListComponent<User, UserListService>
  implements OnInit {
  private userService: UserService;

  constructor(route: ActivatedRoute,
              router: Router,
              userListService: UserListService,
              userService: UserService) {
    super(route, router);
    this.dataSource = userListService;
    this.pageIndexParamName = 'user_page';
    this.pageSizeParamName = 'user_size';
    this.userService = userService;
  }

  ngOnInit() {
    super.ngOnInit();

    this.columns = ['id', 'username', 'name', 'surname', 'rank', 'roles', 'command', 'icon-edit', 'icon-delete'];

    this.pagination.page.subscribe(
      (event: PageEvent) => {
        this.dataSource.getPage(event.pageIndex, event.pageSize);
      });
    this.dataSource.getPage(this.pageIndex, this.pageSize);
  }

  delete(user) {
    if (user)
      this.userService.deleteOne(user.id).subscribe(
        resp => {
          this.dataSource.getPage(this.pageIndex, this.pageSize);
        },
        error => {

        },
        () => {

        }
      );
  }

}
