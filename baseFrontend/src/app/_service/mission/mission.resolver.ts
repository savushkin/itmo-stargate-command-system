import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {Command} from "@sgc/_model/command";
import {CommandService} from "@sgc/_service/command/command.service";
import {Mission} from "@sgc/_model/mission";
import {MissionService} from "@sgc/_service/mission/mission.service";

@Injectable()
export class MissionResolver implements Resolve<Mission> {

  constructor(private missionService: MissionService) {

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.missionService.getOne(route.params.id);
  }

}
