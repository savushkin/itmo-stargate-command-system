import {Injectable} from '@angular/core';
import {CollectionViewer, DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Subscription} from 'rxjs/Subscription';
import {Page} from "@sgc/_model/page";
import {Zone} from "@sgc/_model/zone";
import {ZoneService} from "@sgc/_service/zone/zone.service";

@Injectable()
export class ZoneListService extends DataSource<Zone> {
  public page: Subject<Page<Zone>> = new Subject();
  public pageLoading: BehaviorSubject<boolean> = new BehaviorSubject(false);
  private currentRequest: Subscription;

  constructor(
    private zoneService: ZoneService) {
    super();
  }

  getPage(page: number, size: number) {
    if (this.currentRequest != null) {
      this.currentRequest.unsubscribe();
    }

    if (!this.pageLoading.getValue()) {
      this.pageLoading.next(true);
    }

    this.currentRequest = this.zoneService.getPage(page, size).subscribe(
      page => {
        this.page.next(page);
      },
      (error) => {

      },
      () => {
        this.pageLoading.next(false);
      }
    );
  }


  connect(collectionViewer: CollectionViewer): Observable<Zone[]> {
    return this.page.map((page) => page.content);
  }

  disconnect(collectionViewer: CollectionViewer): void {
  }

}
