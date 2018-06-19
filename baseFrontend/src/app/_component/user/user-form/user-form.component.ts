import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import 'rxjs/add/operator/map'
import {UserService} from "@sgc/_service/user/user.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "@sgc/_model/user";

@Component({
  selector: 'sgc-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {
  private route: ActivatedRoute;
  private router: Router;
  private userService: UserService;
  private formBuilder: FormBuilder;

  public form: FormGroup;
  public item: any = {};

  @Input()
  public user: User = null;

  constructor(route: ActivatedRoute,
              router: Router,
              userService: UserService,
              formBuilder: FormBuilder) {
    this.route = route;
    this.router = router;
    this.userService = userService;
    this.formBuilder = formBuilder;
  }

  ngOnInit() {
    if (this.user) {
      this.user.userRole = this.user.userRole.map(item => item.role);
      this.item = this.user;
      console.log(this.item)
      this.form = this.formBuilder.group({
        id: new FormControl({
          value: this.item.id,
          disabled: true
        }),
        username: new FormControl(this.item.username,  Validators.required),
        name: new FormControl(this.item.name),
        secondName: new FormControl(this.item.secondName),
        surname: new FormControl(this.item.surname),
        rank: new FormControl(this.item.rank),
        password: new FormControl(null),
        enable: new FormControl(this.item.enable),
        userRole: new FormControl(this.item.userRole),
        command: new FormControl(this.item.command)
      })
    } else {
      this.form = this.formBuilder.group({
        id: new FormControl({
          value: null,
          disabled: true
        }),
        username: new FormControl(null,  Validators.required),
        name: new FormControl(null),
        secondName: new FormControl(null),
        surname: new FormControl(null),
        rank: new FormControl(null),
        password: new FormControl(null),
        enable: new FormControl(null),
        userRole: new FormControl(null),
        command: new FormControl(null)
      })
    }
  }


  save(form) {
    let userRoles = [];
    this.item.userRole.forEach(role => {
      if ( !userRoles.includes(role) ) {
        userRoles.push(role)
      }
    });
    this.item.userRole = userRoles;
    if (form.valid) {
      this.item.userRole = this.item.userRole.map( item => {return {role: item}});
      if (this.item.id) {
        this.userService.updateOne(this.item.id, this.item).subscribe(
          item => {
            this.router.navigate(['../'], {relativeTo: this.route})
          },
          error => {

          },
          () => {

          }
        )

      } else {
        this.userService.createOne(this.item).subscribe(
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
