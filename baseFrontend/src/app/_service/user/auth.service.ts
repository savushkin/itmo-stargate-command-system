import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {User} from "../../_model/user";

@Injectable()
export class AuthService {
  private propertyUserName = 'user';
  private storage:Storage = localStorage;
  public user:BehaviorSubject<User> = new BehaviorSubject(
    JSON.parse(
      this.storage.getItem(this.propertyUserName)));

  constructor(private http: HttpClient) { }

  login(username:string, password:string, callback?) {
    let data = new FormData();
    data.append('username', username);
    data.append('password', password);
    return this.http.post<User>(
      `/${environment.contextAuth}/${environment.server.login}`,
      data)
      .subscribe(
        user => {
          this.storage.setItem(this.propertyUserName, JSON.stringify(user));
          this.user.next(user);
          if (callback) {
            callback();
          }
        },
        err => {
        }, () => {

        }
      );
  }

  logout(callback?) {
    this.storage.removeItem(this.propertyUserName);
    this.user.next(null);

    return this.http.get(
      `/${environment.contextAuth}/${environment.server.logout}`)
      .subscribe(
        resp => {
          if (callback) {
            callback();
          }
        },
        err => {
          if (callback) {
            callback();
          }
        }, () => {

        }
      );
  }

}
