import { Injectable } from '@angular/core';
import {User} from "../../_model/user";
import {Page} from "../../_model/page";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Command} from "@sgc/_model/command";
import {Mission} from "@sgc/_model/mission";

@Injectable()
export class MissionService {

  constructor(private http: HttpClient) { }

  getPage(page: number, size: number): Observable<Page<Mission>> {
    const params: HttpParams = new HttpParams()
      .append('page', `${page}`)
      .append('size', `${size}`);
    return this.http.get<Page<Mission>>(
      `/${environment.context}/${environment.api.mission}`,
      { params }
    );
  }

  create(description: string, date: Date, zoneId: number, commandId: number) {
    let data: FormData = new FormData();
    data.append('description', description);
    data.append('date', `${date.toISOString()}`);
    data.append('zoneId', zoneId+'');
    data.append('commandId', commandId+'');
    return this.http.post(
      `/${environment.context}/${environment.api.mission}`,
      data
    ).subscribe(
      (resp) => {
        console.log(resp);
      },
      (err) => {
        console.log(err);
      },
      () => {
      }
    );
  }
}
