import {Injectable} from '@angular/core';
import {User} from "@sgc/_model/user";
import {Page} from "@sgc/_model/page";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "@env/environment";

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  getPage(page: number, size: number): Observable<Page<User>> {
    const params: HttpParams = new HttpParams()
      .append('page', `${page}`)
      .append('size', `${size}`);
    return this.http.get<Page<User>>(
      `/${environment.context}/${environment.api.user}`,
      { params }
    );
  }

}
