import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginPageComponent} from "@sgc/_component/page/login-page/login-page.component";
import {LogoutPageComponent} from "@sgc/_component/page/logout-page/logout-page.component";
import {ProfilePageComponent} from "@sgc/_component/page/profile-page/profile-page.component";
import {UserListPageComponent} from "@sgc/_component/page/user-list-page/user-list-page.component";
import {CommandListPageComponent} from "@sgc/_component/page/command-list-page/command-list-page.component";
import {ZoneListPageComponent} from "@sgc/_component/page/zone-list-page/zone-list-page.component";
import {MissionListPageComponent} from "@sgc/_component/page/mission-list-page/mission-list-page.component";
import {MissionCreatePageComponent} from "@sgc/_component/page/mission-create-page/mission-create-page.component";
import {UserCreatePageComponent} from "@sgc/_component/page/user-create-page/user-create-page.component";
import {UserEditPageComponent} from "@sgc/_component/page/user-edit-page/user-edit-page.component";
import {UserResolver} from "@sgc/_service/user/user.resolver";
import {CommandCreatePageComponent} from "@sgc/_component/page/command-create-page/command-create-page.component";
import {CommandResolver} from "@sgc/_service/command/command.resolver";
import {CommandEditPageComponent} from "@sgc/_component/page/command-edit-page/command-edit-page.component";
import {ZoneCreatePageComponent} from "@sgc/_component/page/zone-create-page/zone-create-page.component";
import {ZoneEditPageComponent} from "@sgc/_component/page/zone-edit-page/zone-edit-page.component";
import {ZoneResolver} from "@sgc/_service/zone/zone.resolver";
import {MissionEditPageComponent} from "@sgc/_component/page/mission-edit-page/mission-edit-page.component";
import {MissionResolver} from "@sgc/_service/mission/mission.resolver";

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
    path: 'profile',
    component: ProfilePageComponent
  },
  {
    path: 'user',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: UserListPageComponent,
      },
      {
        path: 'create',
        component: UserCreatePageComponent
      },
      {
        path: ':id',
        resolve: {
          user : UserResolver
        },
        component: UserEditPageComponent
      }
    ]
  },
  {
    path: 'command',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: CommandListPageComponent,
      },
      {
        path: 'create',
        component: CommandCreatePageComponent
      },
      {
        path: ':id',
        resolve: {
          command : CommandResolver
        },
        component: CommandEditPageComponent
      }
    ]
  },
  {
    path: 'zone',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: ZoneListPageComponent,
      },
      {
        path: 'create',
        component: ZoneCreatePageComponent
      },
      {
        path: ':id',
        resolve: {
          zone: ZoneResolver
        },
        component: ZoneEditPageComponent
      }
    ]
  },
  {
    path: 'mission',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: MissionListPageComponent,
      },
      {
        path: 'create',
        component: MissionCreatePageComponent
      },
      {
        path: ':id',
        resolve: {
          mission: MissionResolver
        },
        component: MissionEditPageComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
