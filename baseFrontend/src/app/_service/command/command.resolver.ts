import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {Command} from "@sgc/_model/command";
import {CommandService} from "@sgc/_service/command/command.service";

@Injectable()
export class CommandResolver implements Resolve<Command> {

  constructor(private commandService: CommandService) {

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.commandService.getOne(route.params.id);
  }

}
