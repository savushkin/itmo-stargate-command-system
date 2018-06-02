import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {User} from "@sgc/_model/user";
import {Injectable} from "@angular/core";
import {UserService} from "@sgc/_service/user/user.service";

@Injectable()
export class UserResolver implements Resolve<User> {

  constructor(private userService: UserService) {

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.userService.getOne(route.params.id);
  }

}
