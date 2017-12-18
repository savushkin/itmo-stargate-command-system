import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PageNotFoundComponent} from "../_component/page/page-not-found/page-not-found.component";
import {LoginPageComponent} from "../_component/page/login-page/login-page.component";
import {LogoutPageComponent} from "../_component/page/logout-page/logout-page.component";
import {ReportListPageComponent} from "../_component/page/report-list-page/report-list-page.component";
import {ReportPageComponent} from "../_component/page/report-page/report-page.component";
import {AddressListPageComponent} from "../_component/page/address-list-page/address-list-page.component";
import {AddressPageComponent} from "../_component/page/address-page/address-page.component";
import {ReportCreatePageComponent} from "../_component/page/report-create-page/report-create-page.component";
import {AddressCreatePageComponent} from "../_component/page/address-create-page/address-create-page.component";
import {ZoneListPageComponent} from "../_component/page/zone-list-page/zone-list-page.component";
import {ZonePageComponent} from "../_component/page/zone-page/zone-page.component";
import {ZoneCreatePageComponent} from "../_component/page/zone-create-page/zone-create-page.component";
import {BaseListPageComponent} from "../_component/page/base-list-page/base-list-page.component";
import {MissionListPageComponent} from "../_component/page/mission-list-page/mission-list-page.component";
import {MissionPageComponent} from "../_component/page/mission-page/mission-page.component";
import {MissionCreatePageComponent} from "../_component/page/mission-create-page/mission-create-page.component";
import {UserListPageComponent} from "../_component/page/user-list-page/user-list-page.component";
import {UserCreatePageComponent} from "../_component/page/user-create-page/user-create-page.component";
import {UserPageComponent} from "../_component/page/user-page/user-page.component";
import {StargatePageComponent} from "../_component/page/stargate-page/stargate-page.component";

const routes: Routes = [
  {
    path: 'login',
    component: LoginPageComponent
  },
  {
    path: 'logout',
    component: LogoutPageComponent
  },
  {
    path: 'report',
    children: [
      {
        path: 'list',
        component: ReportListPageComponent
      },
      {
        path: ':id',
        component: ReportPageComponent
      },
      {
        path: '',
        component: ReportCreatePageComponent
      }
    ]
  },
  {
    path: 'address',
    children: [
      {
        path: 'list',
        component: AddressListPageComponent
      },
      {
        path: ':id',
        component: AddressPageComponent
      },
      {
        path: '',
        component: AddressCreatePageComponent
      }
    ]
  },
  {
    path: 'zone',
    children: [
      {
        path: 'list',
        component: ZoneListPageComponent
      },
      {
        path: ':id',
        component: ZonePageComponent
      },
      {
        path: '',
        component: ZoneCreatePageComponent
      }
    ]
  },
  {
    path: 'mission',
    children: [
      {
        path: 'list',
        component: MissionListPageComponent
      },
      {
        path: ':id',
        component: MissionPageComponent
      },
      {
        path: '',
        component: MissionCreatePageComponent
      }
    ]
  },
  {
    path: 'user',
    children: [
      {
        path: 'list',
        component: UserListPageComponent
      },
      {
        path: ':id',
        component: UserPageComponent
      },
      {
        path: '',
        component: UserCreatePageComponent
      }
    ]
  },
  {
    path: 'base',
    children: [
      {
        path: 'list',
        component: BaseListPageComponent
      }
    ]
  },
  {
    path: 'stargate',
    component: StargatePageComponent
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
