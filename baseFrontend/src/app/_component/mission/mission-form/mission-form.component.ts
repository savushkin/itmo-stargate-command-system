import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import 'rxjs/add/operator/map'
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Command} from "@sgc/_model/command";
import {CommandService} from "@sgc/_service/command/command.service";
import {Subject} from "rxjs/Subject";
import {MissionService} from "@sgc/_service/mission/mission.service";
import {ZoneService} from "@sgc/_service/zone/zone.service";
import {Mission} from "@sgc/_model/mission";
import {Zone} from "@sgc/_model/zone";
import * as moment from 'moment';

@Component({
  selector: 'sgc-mission-form',
  templateUrl: './mission-form.component.html',
  styleUrls: ['./mission-form.component.scss']
})
export class MissionFormComponent implements OnInit {
  private route: ActivatedRoute;
  private router: Router;
  private missionService: MissionService;
  private zoneService: ZoneService;
  private commandService: CommandService;
  private formBuilder: FormBuilder;

  public now = moment();
  public availableZones: Subject<Zone[]> = new Subject<Zone[]>();
  public availableCommands: Subject<Command[]> = new Subject<Command[]>();

  public form: FormGroup;
  public item: any = {
    description: ''
  };

  @Input()
  public mission: Mission = null;

  constructor(route: ActivatedRoute,
              router: Router,
              missionService: MissionService,
              zoneService: ZoneService,
              commandService: CommandService,
              formBuilder: FormBuilder) {
    this.route = route;
    this.router = router;
    this.commandService = commandService;
    this.missionService = missionService;
    this.zoneService = zoneService;
    this.formBuilder = formBuilder;
  }

  ngOnInit() {
    this.commandService.getPage(0, 9999).subscribe(
      page => this.availableCommands.next(page.content));
    this.zoneService.getPage(0, 9999).subscribe(
      page => this.availableZones.next(page.content));

    if (this.mission) {
      this.item = this.mission;
      this.form = this.formBuilder.group({
        id: new FormControl({
          value: this.item.id,
          disabled: true
        }),
        name: new FormControl(this.item.name,  Validators.required),
        zone: new FormControl(this.item.zone.id,  Validators.required),
        command: new FormControl(this.item.command.id,  Validators.required),
        dateDeparture: new FormControl(moment(this.item.dateDeparture)),
        description: new FormControl(this.item.description)
      });
    } else {
      this.form = this.formBuilder.group({
        id: new FormControl({
          value: null,
          disabled: true
        }),
        name: new FormControl(null,  Validators.required),
        zone: new FormControl(null,  Validators.required),
        command: new FormControl(null,  Validators.required),
        dateDeparture: new FormControl(null),
        description: new FormControl(null)
      })
    }
  }

  save(form) {
    if (form.valid) {
      if (this.form.get('dateDeparture').value)
        this.item.dateDeparture = this.form.get('dateDeparture').value.format('x');

      if (this.item.id) {
        this.missionService.updateOne(this.item.id, this.item).subscribe(
          item => {
            this.router.navigate(['../'], {relativeTo: this.route})
          },
          error => {

          },
          () => {

          }
        )

      } else {
        this.missionService.createOne(this.item).subscribe(
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

  selectCommand(id) {
    if (id) {
      this.item['command'] = {};
      this.item['command']['id'] = id;
    } else {
      this.item['command'] = null;
    }
  }

  selectZone(id) {
    if (id) {
      this.item['zone'] = {};
      this.item['zone']['id'] = id;
    } else {
      this.item['zone'] = null;
    }
  }

}
