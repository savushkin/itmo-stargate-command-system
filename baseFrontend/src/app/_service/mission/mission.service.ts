import { Injectable } from '@angular/core';
import {User} from "../../_model/user";
import {Page} from "../../_model/page";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
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

  getOne(id: number): Observable<Mission> {
    const params: HttpParams = new HttpParams();
    return this.http.get<Mission>(
      `/${environment.context}/${environment.api.mission}/${id}`,
      { params }
    );
  }

  createOne(mission: any) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(
      `/${environment.context}/${environment.api.mission}`,
      JSON.stringify(mission),
      { headers }
    );
  }

  updateOne(id: number, mission: any) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put(
      `/${environment.context}/${environment.api.mission}/${id}`,
      JSON.stringify(mission),
      { headers }
    );
  }

  delete(id: number) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.delete(
      `/${environment.context}/${environment.api.mission}/${id}`,
      { headers }
    );
  }

  approve(id: number) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put(
      `/${environment.context}/${environment.api.mission}/${id}/approve/`,
      null,
      { headers }
    );
  }

  cancel(id: number) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put(
      `/${environment.context}/${environment.api.mission}/${id}/cancel/`,
      null,
      { headers }
    );
  }
}
