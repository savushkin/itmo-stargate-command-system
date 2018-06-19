import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import 'rxjs/add/operator/map'
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ZoneService} from "@sgc/_service/zone/zone.service";
import {Zone} from "@sgc/_model/zone";
import {Subject} from "rxjs/Subject";
import {Address} from "@sgc/_model/address";
import {StargateService} from "@sgc/_service/stargate/stargate.service";

@Component({
  selector: 'sgc-stargate-state',
  templateUrl: './stargate-state.component.html',
  styleUrls: ['./stargate-state.component.scss']
})
export class StargateStateComponent implements OnInit {
  private route: ActivatedRoute;
  private router: Router;
  private zoneService: ZoneService;
  private stargateService: StargateService;

  public addresses: Subject<Address[]> = new Subject<Address[]>();

  public state: any = {};
  public selectedAddress;

  constructor(route: ActivatedRoute,
              router: Router,
              zoneService: ZoneService,
              stargateService: StargateService) {
    this.route = route;
    this.router = router;
    this.zoneService = zoneService;
    this.stargateService = stargateService;
  }

  ngOnInit() {
    this.zoneService.getAllAddressStarGate(0, 9999).subscribe(
      pageAddresses => this.addresses.next(pageAddresses.content),
      error => console.log(error),
      () => { }
    );

    this.stargateService.state.subscribe(
      state => this.state = state
    );

    this.stargateService.loadState();
  }

  selectAddress(addressStarGateId) {
    if (addressStarGateId) {
      this.selectedAddress = addressStarGateId;
    } else {
      this.selectedAddress = null;
    }
  }

  open() {
    this.stargateService.open(this.selectedAddress).subscribe(
      resp => this.stargateService.loadState()
    )
  }

  close() {
    this.stargateService.close().subscribe(
      resp => this.stargateService.loadState()
    )
  }

  toggleIris() {
    this.stargateService.toggleIris().subscribe(
      resp => this.stargateService.loadState()
    )
  }
}
