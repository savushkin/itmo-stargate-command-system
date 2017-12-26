import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginPageComponent} from "@sgc/_component/page/login-page/login-page.component";
import {LogoutPageComponent} from "@sgc/_component/page/logout-page/logout-page.component";
import {ProfilePageComponent} from "@sgc/_component/page/profile-page/profile-page.component";
import {UserListPageComponent} from "@sgc/_component/page/user-list-page/user-list-page.component";
import {CommandListPageComponent} from "@sgc/_component/page/command-list-page/command-list-page.component";

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
    component: UserListPageComponent,
    children: [

    ]
  },
  {
    path: 'command',
    component: CommandListPageComponent,
    children: [

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
