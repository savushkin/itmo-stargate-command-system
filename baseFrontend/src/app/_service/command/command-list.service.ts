import {Injectable} from '@angular/core';
import {CollectionViewer, DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Subscription} from 'rxjs/Subscription';
import {Page} from "@sgc/_model/page";
import {CommandService} from "@sgc/_service/command/command.service";
import {Command} from "@sgc/_model/command";

@Injectable()
export class CommandListService extends DataSource<Command> {
  public page: Subject<Page<Command>> = new Subject();
  public pageLoading: BehaviorSubject<boolean> = new BehaviorSubject(false);
  private currentRequest: Subscription;

  constructor(
    private commandService: CommandService) {
    super();
  }

  getPage(page: number, size: number) {
    if (this.currentRequest != null) {
      this.currentRequest.unsubscribe();
    }

    if (!this.pageLoading.getValue()) {
      this.pageLoading.next(true);
    }

    this.currentRequest = this.commandService.getPage(page, size).subscribe(
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


  connect(collectionViewer: CollectionViewer): Observable<Command[]> {
    return this.page.map((page) => page.content);
  }

  disconnect(collectionViewer: CollectionViewer): void {
  }

}
