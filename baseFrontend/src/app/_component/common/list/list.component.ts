import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, PageEvent} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {Page} from "../../../_model/page";

@Component({
  selector: 'sgc-list',
  template: '<div></div>'
})
export class ListComponent<T, S> implements OnInit {
  protected route: ActivatedRoute;
  protected router: Router;
  protected pageIndexParamName = 'index';
  protected pageSizeParamName = 'size';

  public dataSource: S | null = null;

  public columns: string[] = [];
  public pageIndex = 0;
  public pageSize = 15;
  public itemsCount = 0;
  public pageSizeOptions: number[] = [5, 15, 30, 50, 100];
  public pageLoading = false;

  @ViewChild(MatPaginator)
  protected pagination: MatPaginator;

  constructor(route: ActivatedRoute,
              router: Router) {
    this.route = route;
    this.router = router;
  }

  ngOnInit(): void {
    this.dataSource['pageLoading'].subscribe(
      (isLoading) => {
        this.pageLoading = isLoading;
      });

    this.dataSource['page'].subscribe(
      (page: Page<T>) => {
        this.pageIndex = page.number;
        this.pageSize = page.size;
        this.itemsCount = page.totalElements;
      });

    this.pagination.page.subscribe(
      (event: PageEvent) => {
        const queryParams = {...this.route.snapshot.queryParams};
        queryParams[this.pageIndexParamName] = `${event.pageIndex}`;
        queryParams[this.pageSizeParamName] = `${event.pageSize}`;
        const prom = this.router.navigate(
          [],
          {
            queryParams,
            relativeTo: this.route
          }
        );
      });

    const routePage = parseInt(this.route.snapshot.queryParams[this.pageIndexParamName], 10),
      routeSize = parseInt(this.route.snapshot.queryParams[this.pageSizeParamName], 10);
    this.pageIndex = routePage || this.pageIndex;
    this.pageSize = routeSize || this.pageSize;

    const queryParams = {...this.route.snapshot.queryParams};
    queryParams[this.pageIndexParamName] = `${this.pageIndex}`;
    queryParams[this.pageSizeParamName] = `${this.pageSize}`;
    const prom = this.router.navigate(
      [],
      {
        queryParams,
        relativeTo: this.route
      }
    );
  }

}
