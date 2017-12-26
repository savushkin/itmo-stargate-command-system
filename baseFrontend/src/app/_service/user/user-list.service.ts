import {Injectable} from '@angular/core';
import {CollectionViewer, DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Subscription} from 'rxjs/Subscription';
import {User} from "@sgc/_model/user";
import {Page} from "@sgc/_model/page";
import {UserService} from "@sgc/_service/user/user.service";

@Injectable()
export class UserListService extends DataSource<User> {
  public page: Subject<Page<User>> = new Subject();
  public pageLoading: BehaviorSubject<boolean> = new BehaviorSubject(false);
  private currentRequest: Subscription;

  constructor(
    private userService: UserService) {
    super();
  }

  getPage(page: number, size: number) {
    if (this.currentRequest != null) {
      this.currentRequest.unsubscribe();
    }

    if (!this.pageLoading.getValue()) {
      this.pageLoading.next(true);
    }

    this.currentRequest = this.userService.getPage(page, size).subscribe(
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


  connect(collectionViewer: CollectionViewer): Observable<User[]> {
    return this.page.map((page) => page.content);
  }

  disconnect(collectionViewer: CollectionViewer): void {
  }

}
