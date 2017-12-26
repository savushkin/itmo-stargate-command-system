import { Injectable } from '@angular/core';
import {User} from "../../_model/user";
import {Page} from "../../_model/page";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Command} from "@sgc/_model/command";
import {Zone} from "@sgc/_model/zone";

@Injectable()
export class CommandService {

  constructor(private http: HttpClient) { }

  getPage(page: number, size: number): Observable<Page<Command>> {
    const params: HttpParams = new HttpParams()
      .append('page', `${page}`)
      .append('size', `${size}`);
    return this.http.get<Page<Command>>(
      `/${environment.context}/${environment.api.command}`,
      { params }
    );
  }

  findByCommandTypeName(query:string): Observable<Command[]> {
    const params: HttpParams = new HttpParams()
      .append('query', `${query}`);
    return this.http.get<Command[]>(
      `/${environment.context}/${environment.api.command}/${environment.api.find}`,
      { params }
    );
  }

  getTypesPage(page: number, size: number): Observable<Page<User>> {
    const params: HttpParams = new HttpParams()
      .append('page', `${page}`)
      .append('size', `${size}`);
    return this.http.get<Page<User>>(
      `/${environment.context}/${environment.api.command}`,
      { params }
    );
  }

}
