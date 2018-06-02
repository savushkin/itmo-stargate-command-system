import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import 'rxjs/add/operator/map'
import {UserService} from "@sgc/_service/user/user.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "@sgc/_model/user";
import {Command} from "@sgc/_model/command";
import {CommandService} from "@sgc/_service/command/command.service";
import {Subject} from "rxjs/Subject";

@Component({
  selector: 'sgc-command-form',
  templateUrl: './command-form.component.html',
  styleUrls: ['./command-form.component.scss']
})
export class CommandFormComponent implements OnInit {
  private route: ActivatedRoute;
  private router: Router;
  private commandService: CommandService;
  private userService: UserService;
  private formBuilder: FormBuilder;

  public avalibleUsers: Subject<User[]> = new Subject<User[]>();

  public form: FormGroup;
  public item: any = {
    commandType: {
      id: 1
    },
    description: null
  };

  @Input()
  public command: Command = null;

  constructor(route: ActivatedRoute,
              router: Router,
              commandService: CommandService,
              userService: UserService,
              formBuilder: FormBuilder) {
    this.route = route;
    this.router = router;
    this.commandService = commandService;
    this.userService = userService;
    this.formBuilder = formBuilder;
  }

  ngOnInit() {
    this.userService.getAllForCommand(this.command?this.command.id:null).subscribe(
      (users) => {
        this.avalibleUsers.next(users);
      }
    );
    if (this.command) {
      this.item = this.command;
      this.item.members = this.item.members.map(item => item.id);
      this.form = this.formBuilder.group({
        id: new FormControl({
          value: this.item.id,
          disabled: true
        }),
        name: new FormControl(this.item.name,  Validators.required),
        commandType: new FormControl(this.item.commandType.id),
        description: new FormControl(this.item.description),
        members: new FormControl(this.item.members, Validators.required)
      });
    } else {
      this.form = this.formBuilder.group({
        id: new FormControl({
          value: null,
          disabled: true
        }),
        name: new FormControl(null,  Validators.required),
        commandType: new FormControl(0),
        description: new FormControl(null),
        members: new FormControl(null, Validators.required)
      })
    }
  }


  save(form) {
    console.log(this.item.members)
    this.form.controls['members'].setValue(this.item.members);
    if (form.valid) {
      this.item.members = this.item.members.map(item => {
        return {id: item}
      });
      if (this.item.id) {
        this.commandService.updateOne(this.item.id, this.item).subscribe(
          item => {
            this.router.navigate(['../'], {relativeTo: this.route})
          },
          error => {

          },
          () => {

          }
        )

      } else {
        this.commandService.createOne(this.item).subscribe(
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
}
