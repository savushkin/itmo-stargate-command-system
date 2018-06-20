import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {environment} from "@env/environment";
import {Command} from "@sgc/_model/command";
import {Subject} from "rxjs/Subject";

@Injectable()
export class StargateService {
  public state: Subject<any> = new Subject<Command[]>();

  constructor(private http: HttpClient) {

  }

  toggleIris() {
    return this.http.get<any>(
      `/${environment.context}/${environment.api.stargate}/toggle-iris`,
      {  }
    );
  }

  open(id) {
    return this.http.get<any>(
      `/${environment.context}/${environment.api.stargate}/open/${id}`,
      {  }
    );
  }

  close() {
    return this.http.get<any>(
      `/${environment.context}/${environment.api.stargate}/close`,
      {  }
    );
  }

  getStarGateState(): Observable<any> {
    return this.http.get<any>(
      `/${environment.context}/${environment.api.stargate}/${environment.api.state}`,
      {  }
    );
  }

  public loadState() {
    this.getStarGateState().subscribe(
      state => this.state.next(state),
      error => this.state.next(null)
    );
  }

}
