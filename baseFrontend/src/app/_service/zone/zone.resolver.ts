import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {Zone} from "@sgc/_model/zone";
import {ZoneService} from "@sgc/_service/zone/zone.service";

@Injectable()
export class ZoneResolver implements Resolve<Zone> {

  constructor(private zoneService: ZoneService) {

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.zoneService.getOne(route.params.id);
  }

}
