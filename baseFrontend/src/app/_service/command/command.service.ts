import {Injectable} from '@angular/core';
import {User} from "@sgc/_model/user";
import {Page} from "@sgc/_model/page";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "@env/environment";
import {Command} from "@sgc/_model/command";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable()
export class CommandService {
  public commands: BehaviorSubject<Command[]> = new BehaviorSubject<Command[]>([]);

  constructor(private http: HttpClient) {
    this.loadCommands();
  }

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

  getOne(id: number): Observable<Command> {
    const params: HttpParams = new HttpParams();
    return this.http.get<Command>(
      `/${environment.context}/${environment.api.command}/${id}`,
      { params }
    );
  }

  createOne(user: any): Observable<Command> {
    const params: HttpParams = new HttpParams();
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<Command>(
      `/${environment.context}/${environment.api.command}`,
      JSON.stringify(user),
      { params, headers }
    ).do(() => {
      this.loadCommands();
    });
  }

  updateOne(id: number, user: any): Observable<Command> {
    const params: HttpParams = new HttpParams();
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put<Command>(
      `/${environment.context}/${environment.api.command}/${id}`,
      JSON.stringify(user),
      { params, headers }
    ).do(() => {
      this.loadCommands();
    });
  }

  deleteOne(id: number): Observable<any> {
    const params: HttpParams = new HttpParams();
    return this.http.delete<any>(
      `/${environment.context}/${environment.api.command}/${id}`,
      { params }
    ).do(() => {
      this.loadCommands();
    });
  }

  private loadCommands() {
    this.getPage(0, 9999).subscribe(
      commands => {
        this.commands.next(commands.content);
      }
    )
  }

}
