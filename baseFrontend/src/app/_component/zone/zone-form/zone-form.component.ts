import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import 'rxjs/add/operator/map'
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ZoneService} from "@sgc/_service/zone/zone.service";
import {Zone} from "@sgc/_model/zone";
import {Subject} from "rxjs/Subject";
import {Address} from "@sgc/_model/address";

@Component({
  selector: 'sgc-zone-form',
  templateUrl: './zone-form.component.html',
  styleUrls: ['./zone-form.component.scss']
})
export class ZoneFormComponent implements OnInit {
  private route: ActivatedRoute;
  private router: Router;
  private zoneService: ZoneService;
  private formBuilder: FormBuilder;

  public form: FormGroup;
  public item: any = {
    addressStarGate: {
      id: null,
      humanName: null
    }
  };

  public addresses: Subject<Address[]> = new Subject<Address[]>();

  @Input()
  public zone: Zone = null;

  constructor(route: ActivatedRoute,
              router: Router,
              zoneService: ZoneService,
              formBuilder: FormBuilder) {
    this.route = route;
    this.router = router;
    this.zoneService = zoneService;
    this.formBuilder = formBuilder;
  }

  ngOnInit() {
    this.zoneService.getAllAddressStarGate(0, 9999).subscribe(
      pageAddresses => this.addresses.next(pageAddresses.content),
      error => console.log(error),
      () => { }
    );

    if (this.zone) {
      this.item = this.zone;

      this.form = this.formBuilder.group({
        id: new FormControl({
          value: this.item.id,
          disabled: true
        }),
        name: new FormControl(this.item.name,  Validators.required),
        climaticConditions: new FormControl(this.item.climaticConditions),
        mititaryThreats: new FormControl(this.item.mititaryThreats),
        minerals: new FormControl(this.item.minerals),
        addressStarGate: new FormControl(this.item.addressStarGate)
      });
    } else {
      this.form = this.formBuilder.group({
        id: new FormControl({
          value: null,
          disabled: true
        }),
        name: new FormControl(null,  Validators.required),
        climaticConditions: new FormControl(null),
        mititaryThreats: new FormControl(null),
        minerals: new FormControl(null),
        addressStarGate: new FormControl(null)
      })
    }
  }


  save(form) {
    if (form.valid) {
      if (this.item.id) {
        this.zoneService.updateOne(this.item.id, this.item).subscribe(
          item => {
            this.router.navigate(['../'], {relativeTo: this.route})
          },
          error => {

          },
          () => {

          }
        )

      } else {
        this.zoneService.createOne(this.item).subscribe(
          item => {
            this.router.navigate(['../'], {relativeTo: this.route})
          },
          error => {

          },
          () => {

          }
        )
      }
    }
  }

  selectAddress(addressStarGateId) {
    if (addressStarGateId) {
      this.item['addressStarGate']['id'] = addressStarGateId;
      // this.item['name'] = ;
    }
  }
}
