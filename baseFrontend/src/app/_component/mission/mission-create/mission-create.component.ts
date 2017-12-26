import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MatAutocomplete} from '@angular/material';
import 'rxjs/add/operator/map'
import {MissionService} from "@sgc/_service/mission/mission.service";
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {Zone} from "@sgc/_model/zone";
import {ZoneService} from "@sgc/_service/zone/zone.service";
import {CommandService} from "@sgc/_service/command/command.service";
import 'rxjs/add/operator/switchMap';
import {Command} from "@sgc/_model/command";

@Component({
  selector: 'sgc-mission-create',
  templateUrl: './mission-create.component.html',
  styleUrls: ['./mission-create.component.scss']
})
export class MissionCreateComponent implements OnInit {
  public now: Date = new Date();

  public zoneCtrl: FormControl = new FormControl();
  public commandCtrl: FormControl = new FormControl();
  public filteredZone: Observable<Zone[]>;
  public filteredCommand: Observable<Command[]>;

  @ViewChild('searchZone')
  searchZone: MatAutocomplete;
  @ViewChild('searchCommand')
  searchCommand: MatAutocomplete;

  public description:string = '';
  public date:Date = new Date(this.now.getTime() + (7*24*60*60*1000));
  public zoneId:number;
  public commandId:number;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private missionService: MissionService,
              private zoneService: ZoneService,
              private commandService: CommandService) {

  }

  ngOnInit() {
    this.searchZone.optionSelected.subscribe(
      (event) => {
        this.zoneId = event.option.value;
      }, (error) => {

      }, () => {

      }
    );
    this.searchCommand.optionSelected.subscribe(
      (event) => {
        this.commandId = event.option.value;
      }, (error) => {

      }, () => {

      }
    );
    this.filteredZone = this.zoneCtrl
      .valueChanges
      .switchMap((query, index) => this.filterZone(query));
    this.filteredCommand = this.commandCtrl
      .valueChanges
      .switchMap((query, index) => this.filterCommand(query));
    this.zoneCtrl.setValue('');
    this.commandCtrl.setValue('');
  }

  filterCommand(query: string) {
    return this.commandService.findByCommandTypeName(query);
  }

  filterZone(query: string) {
    return this.zoneService.findByZoneName(query);
  }

  createMission() {
    this.missionService.create(
      this.description,
      this.date,
      this.zoneId,
      this.commandId
    )
  }

}
