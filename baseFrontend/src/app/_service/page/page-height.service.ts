import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable()
export class PageHeightService {
  height:BehaviorSubject<number> = new BehaviorSubject<number>(0);

  constructor() { }

}
