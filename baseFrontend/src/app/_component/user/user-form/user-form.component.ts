import {Component, OnInit} from '@angular/core';
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
    });
  }


  save(form) {
    console.log(form.valid);
    console.log(form.value);
    console.log(this.item);
    if (form.valid) {
      if (form.value.id) {

      } else {
        this.userService.createOne(this.item).subscribe(
          item => {
            console.log(item);
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
