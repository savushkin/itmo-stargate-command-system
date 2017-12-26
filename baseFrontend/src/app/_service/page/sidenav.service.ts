import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {AuthService} from "../user/auth.service";
import {User} from "../../_model/user";

@Injectable()
export class SidenavService {
  links: Subject<any[]> = new Subject();
  user:User = null;

  constructor(
    private authService:AuthService) {
    this.user = authService.user.getValue();
    authService.user.subscribe(user => {
      this.user = user;
    });
  }

  pageChanged(route) {
    let navs = [];
    switch (route) {
      case '/user/profile':
        break;
      default:
        break;
    }

    if (this.user) {
      this.user.userRole.forEach(role => {
        switch (role.role) {
          case 'ROLE_ADMINISTRATOR':
            navs.push({
              name: 'Список пользователей',
              url: '/user'
            });
            navs.push({
              name: 'Список комманд',
              url: '/command'
            });
            navs.push({
              name: 'Список зон',
              url: '/zone'
            });
            break;
          case 'ROLE_COMMANDER':
            navs.push({
              name: 'Список пользователей',
              url: '/user'
            });
            navs.push({
              name: 'Список комманд',
              url: '/command'
            });
            navs.push({
              name: 'Список зон',
              url: '/zone'
            });
            break;
          case 'ROLE_USER':
            break;
        }
      })
    }

    if (this.user) {
      navs.push({
        name: 'Выход',
        url: '/logout'
      });
    } else {
      navs.push({
        name: 'Вход',
        url: '/login'
      });
    }
    this.links.next(navs);
    console.log(route);
  }

}
