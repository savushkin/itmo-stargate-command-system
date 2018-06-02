import {Injectable} from '@angular/core';
import {User} from "@sgc/_model/user";
import {Page} from "@sgc/_model/page";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
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

  getOne(id: number): Observable<User> {
    const params: HttpParams = new HttpParams();
    return this.http.get<User>(
      `/${environment.context}/${environment.api.user}/${id}`,
      { params }
    );
  }

  createOne(user: any): Observable<User> {
    const params: HttpParams = new HttpParams();
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<User>(
      `/${environment.context}/${environment.api.user}`,
      JSON.stringify(user),
      { params, headers }
    );
  }

  updateOne(id: number, user: any): Observable<User> {
    const params: HttpParams = new HttpParams();
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put<User>(
      `/${environment.context}/${environment.api.user}/${id}`,
      JSON.stringify(user),
      { params, headers }
    );
  }

  deleteOne(id: number): Observable<any> {
    const params: HttpParams = new HttpParams();
    return this.http.delete<any>(
      `/${environment.context}/${environment.api.user}/${id}`,
      { params }
    );
  }

}
