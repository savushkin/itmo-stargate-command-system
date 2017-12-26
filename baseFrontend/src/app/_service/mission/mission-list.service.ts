import {Injectable} from '@angular/core';
import {CollectionViewer, DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Subscription} from 'rxjs/Subscription';
import {Page} from "@sgc/_model/page";
import {Mission} from "@sgc/_model/mission";
import {MissionService} from "@sgc/_service/mission/mission.service";

@Injectable()
export class MissionListService extends DataSource<Mission> {
  public page: Subject<Page<Mission>> = new Subject();
  public pageLoading: BehaviorSubject<boolean> = new BehaviorSubject(false);
  private currentRequest: Subscription;

  constructor(
    private missionService: MissionService) {
    super();
  }

  getPage(page: number, size: number) {
    if (this.currentRequest != null) {
      this.currentRequest.unsubscribe();
    }

    if (!this.pageLoading.getValue()) {
      this.pageLoading.next(true);
    }

    this.currentRequest = this.missionService.getPage(page, size).subscribe(
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


  connect(collectionViewer: CollectionViewer): Observable<Mission[]> {
    return this.page.map((page) => page.content);
  }

  disconnect(collectionViewer: CollectionViewer): void {
  }

}
