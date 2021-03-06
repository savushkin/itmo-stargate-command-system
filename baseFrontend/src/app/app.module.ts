import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from "@sgc/app.component";
import {PageComponent} from "@sgc/_component/page/page/page.component";
import {ProfilePageComponent} from "@sgc/_component/page/profile-page/profile-page.component";
import {PageNotFoundComponent} from "@sgc/_component/page/page-not-found/page-not-found.component";
import {LoginPageComponent} from "@sgc/_component/page/login-page/login-page.component";
import {LogoutPageComponent} from "@sgc/_component/page/logout-page/logout-page.component";
import {ZoneListPageComponent} from "@sgc/_component/page/zone-list-page/zone-list-page.component";
import {UserListPageComponent} from "@sgc/_component/page/user-list-page/user-list-page.component";
import {GlyphComponent} from "@sgc/_component/stargate/glyph/glyph.component";
import {ListComponent} from "@sgc/_component/common/list/list.component";
import {UserListComponent} from "@sgc/_component/user/user-list/user-list.component";
import {CommandListComponent} from "@sgc/_component/command/command-list/command-list.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppMaterialModule} from "@sgc/_module/app-material.module";
import {AppRoutingModule} from "@sgc/_module/app-routing.module";
import {PageHeightService} from "@sgc/_service/page/page-height.service";
import {GlyphService} from "@sgc/_service/stargate/glyph.service";
import {AuthService} from "@sgc/_service/user/auth.service";
import {SidenavService} from "@sgc/_service/page/sidenav.service";
import {BaseHttpInterceptorService} from "@sgc/_service/network/base-http-interceptor.service";
import {UserService} from "@sgc/_service/user/user.service";
import {UserListService} from "@sgc/_service/user/user-list.service";
import {CommandService} from "@sgc/_service/command/command.service";
import {CommandListService} from "@sgc/_service/command/command-list.service";
import {CommandListPageComponent} from "@sgc/_component/page/command-list-page/command-list-page.component";
import {ZoneListComponent} from "@sgc/_component/zone/zone-list/zone-list.component";
import {ZoneService} from "@sgc/_service/zone/zone.service";
import {ZoneListService} from "@sgc/_service/zone/zone-list.service";
import {MissionListComponent} from "@sgc/_component/mission/mission-list/mission-list.component";
import {MissionService} from "@sgc/_service/mission/mission.service";
import {MissionListService} from "@sgc/_service/mission/mission-list.service";
import {MissionListPageComponent} from "@sgc/_component/page/mission-list-page/mission-list-page.component";
import {MissionCreatePageComponent} from "@sgc/_component/page/mission-create-page/mission-create-page.component";
import {UserEditPageComponent} from "@sgc/_component/page/user-edit-page/user-edit-page.component";
import {UserCreatePageComponent} from "@sgc/_component/page/user-create-page/user-create-page.component";
import {UserFormComponent} from "@sgc/_component/user/user-form/user-form.component";
import {UserResolver} from "@sgc/_service/user/user.resolver";
import {UserRolePipe} from './_pipe/user-role.pipe';
import {CommandPipe} from './_pipe/command.pipe';
import {CommandCreatePageComponent} from "@sgc/_component/page/command-create-page/command-create-page.component";
import {CommandEditPageComponent} from "@sgc/_component/page/command-edit-page/command-edit-page.component";
import {CommandFormComponent} from "@sgc/_component/command/command-form/command-form.component";
import {CommandResolver} from "@sgc/_service/command/command.resolver";
import {ZoneCreatePageComponent} from "@sgc/_component/page/zone-create-page/zone-create-page.component";
import {ZoneEditPageComponent} from "@sgc/_component/page/zone-edit-page/zone-edit-page.component";
import {ZoneFormComponent} from "@sgc/_component/zone/zone-form/zone-form.component";
import {ZoneResolver} from "@sgc/_service/zone/zone.resolver";
import {MissionFormComponent} from "@sgc/_component/mission/mission-form/mission-form.component";
import {MissionEditPageComponent} from "@sgc/_component/page/mission-edit-page/mission-edit-page.component";
import {MissionResolver} from "@sgc/_service/mission/mission.resolver";
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from "@angular/material";
import {MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from "@angular/material-moment-adapter";
import {StargateStateComponent} from "@sgc/_component/stargate/stargate-state/stargate-state.component";
import {StargateStatePageComponent} from "@sgc/_component/page/stargate-state-page/stargate-state-page.component";
import {StargateService} from "@sgc/_service/stargate/stargate.service";


@NgModule({
  declarations: [
    AppComponent,

    // ReportListPageComponent,
    // ReportPageComponent,
    // AddressListPageComponent,
    // AddressPageComponent,
    // ReportCreatePageComponent,
    // AddressCreatePageComponent,
    // BaseListPageComponent,
    // MissionPageComponent,
    // StargatePageComponent,

    GlyphComponent,
    StargateStateComponent,
    StargateStatePageComponent,

    PageComponent,
    ProfilePageComponent,
    PageNotFoundComponent,
    LoginPageComponent,
    LogoutPageComponent,

    UserListPageComponent,
    CommandListPageComponent,
    ZoneListPageComponent,
    MissionListPageComponent,

    UserCreatePageComponent,
    CommandCreatePageComponent,
    MissionCreatePageComponent,
    ZoneCreatePageComponent,

    UserEditPageComponent,
    CommandEditPageComponent,
    MissionEditPageComponent,
    ZoneEditPageComponent,

    ListComponent,
    UserListComponent,
    CommandListComponent,
    ZoneListComponent,
    MissionListComponent,

    MissionFormComponent,
    UserFormComponent,
    CommandFormComponent,
    ZoneFormComponent,

    UserRolePipe,
    CommandPipe
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,

    AppMaterialModule,
    AppRoutingModule
  ],
  providers: [
    PageHeightService,
    GlyphService,
    AuthService,
    SidenavService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BaseHttpInterceptorService,
      multi: true
    },
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},
    UserService,
    UserResolver,
    UserListService,
    CommandService,
    CommandResolver,
    CommandListService,
    ZoneService,
    ZoneResolver,
    ZoneListService,
    MissionService,
    MissionResolver,
    MissionListService,
    StargateService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
