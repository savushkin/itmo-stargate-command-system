import { Injectable } from '@angular/core';
import {User} from "../../_model/user";
import {Page} from "../../_model/page";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Command} from "@sgc/_model/command";
import {Zone} from "@sgc/_model/zone";

@Injectable()
export class ZoneService {

  constructor(private http: HttpClient) { }

  getPage(page: number, size: number): Observable<Page<Zone>> {
    const params: HttpParams = new HttpParams()
      .append('page', `${page}`)
      .append('size', `${size}`);
    return this.http.get<Page<Zone>>(
      `/${environment.context}/${environment.api.zone}`,
      { params }
    );
  }

  findByZoneName(query:string): Observable<Zone[]> {
    const params: HttpParams = new HttpParams()
      .append('query', `${query}`);
    return this.http.get<Zone[]>(
      `/${environment.context}/${environment.api.zone}/${environment.api.find}`,
      { params }
    );
  }

}
