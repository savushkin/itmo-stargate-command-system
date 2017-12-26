import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from "@sgc/app.component";
import {PageComponent} from "@sgc/_component/page/page/page.component";
import {ProfilePageComponent} from "@sgc/_component/page/profile-page/profile-page.component";
import {PageNotFoundComponent} from "@sgc/_component/page/page-not-found/page-not-found.component";
import {LoginPageComponent} from "@sgc/_component/page/login-page/login-page.component";
import {LogoutPageComponent} from "@sgc/_component/page/logout-page/logout-page.component";
import {ReportListPageComponent} from "@sgc/_component/page/temp/report-list-page/report-list-page.component";
import {ReportPageComponent} from "@sgc/_component/page/temp/report-page/report-page.component";
import {AddressListPageComponent} from "@sgc/_component/page/temp/address-list-page/address-list-page.component";
import {AddressPageComponent} from "@sgc/_component/page/temp/address-page/address-page.component";
import {ReportCreatePageComponent} from "@sgc/_component/page/temp/report-create-page/report-create-page.component";
import {AddressCreatePageComponent} from "@sgc/_component/page/temp/address-create-page/address-create-page.component";
import {BaseListPageComponent} from "@sgc/_component/page/temp/base-list-page/base-list-page.component";
import {ZoneListPageComponent} from "@sgc/_component/page/zone-list-page/zone-list-page.component";
import {ZonePageComponent} from "@sgc/_component/page/temp/zone-page/zone-page.component";
import {ZoneCreatePageComponent} from "@sgc/_component/page/temp/zone-create-page/zone-create-page.component";
import {UserPageComponent} from "@sgc/_component/page/temp/user-page/user-page.component";
import {UserListPageComponent} from "@sgc/_component/page/user-list-page/user-list-page.component";
import {UserCreatePageComponent} from "@sgc/_component/page/temp/user-create-page/user-create-page.component";
import {StargatePageComponent} from "@sgc/_component/page/temp/stargate-page/stargate-page.component";
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
import {MissionCreateComponent} from "@sgc/_component/mission/mission-create/mission-create.component";
import {MissionPageComponent} from "@sgc/_component/page/temp/mission-page/mission-page.component";
import {MissionListPageComponent} from "@sgc/_component/page/mission-list-page/mission-list-page.component";
import {MissionCreatePageComponent} from "@sgc/_component/page/mission-create-page/mission-create-page.component";


@NgModule({
  declarations: [
    AppComponent,

    ReportListPageComponent,
    ReportPageComponent,
    AddressListPageComponent,
    AddressPageComponent,
    ReportCreatePageComponent,
    AddressCreatePageComponent,
    BaseListPageComponent,
    ZonePageComponent,
    ZoneCreatePageComponent,
    MissionPageComponent,
    UserPageComponent,
    UserCreatePageComponent,
    StargatePageComponent,

    GlyphComponent,

    PageComponent,
    ProfilePageComponent,
    PageNotFoundComponent,
    LoginPageComponent,
    LogoutPageComponent,
    UserListPageComponent,
    CommandListPageComponent,
    ZoneListPageComponent,
    MissionListPageComponent,

    MissionCreatePageComponent,

    ListComponent,
    UserListComponent,
    CommandListComponent,
    ZoneListComponent,
    MissionListComponent,

    MissionCreateComponent
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

    UserService,
    UserListService,
    CommandService,
    CommandListService,
    ZoneService,
    ZoneListService,
    MissionService,
    MissionListService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
