import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './_module/app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppMaterialModule} from "./_module/app-material.module";
import {PageNotFoundComponent} from './_component/page/page-not-found/page-not-found.component';
import {LoginPageComponent} from './_component/page/login-page/login-page.component';
import {LogoutPageComponent} from './_component/page/logout-page/logout-page.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {PageHeightService} from "./_service/page/page-height.service";
import {ReportListPageComponent} from './_component/page/report-list-page/report-list-page.component';
import {ReportPageComponent} from './_component/page/report-page/report-page.component';
import {AddressListPageComponent} from './_component/page/address-list-page/address-list-page.component';
import {AddressPageComponent} from './_component/page/address-page/address-page.component';
import {ReportCreatePageComponent} from './_component/page/report-create-page/report-create-page.component';
import {AddressCreatePageComponent} from './_component/page/address-create-page/address-create-page.component';
import {BaseListPageComponent} from './_component/page/base-list-page/base-list-page.component';
import {ZoneListPageComponent} from './_component/page/zone-list-page/zone-list-page.component';
import {ZonePageComponent} from './_component/page/zone-page/zone-page.component';
import {ZoneCreatePageComponent} from './_component/page/zone-create-page/zone-create-page.component';
import {MissionCreatePageComponent} from './_component/page/mission-create-page/mission-create-page.component';
import {MissionListPageComponent} from './_component/page/mission-list-page/mission-list-page.component';
import {MissionPageComponent} from './_component/page/mission-page/mission-page.component';
import {UserPageComponent} from './_component/page/user-page/user-page.component';
import {UserListPageComponent} from './_component/page/user-list-page/user-list-page.component';
import {UserCreatePageComponent} from './_component/page/user-create-page/user-create-page.component';
import {StargatePageComponent} from './_component/page/stargate-page/stargate-page.component';
import {GlyphService} from "./_service/stargate/glyph.service";
import { GlyphComponent } from './_component/stargate/glyph/glyph.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    LoginPageComponent,
    LogoutPageComponent,
    ReportListPageComponent,
    ReportPageComponent,
    AddressListPageComponent,
    AddressPageComponent,
    ReportCreatePageComponent,
    AddressCreatePageComponent,
    BaseListPageComponent,
    ZoneListPageComponent,
    ZonePageComponent,
    ZoneCreatePageComponent,
    MissionCreatePageComponent,
    MissionListPageComponent,
    MissionPageComponent,
    UserPageComponent,
    UserListPageComponent,
    UserCreatePageComponent,
    StargatePageComponent,
    GlyphComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,

    AppMaterialModule,
    AppRoutingModule
  ],
  providers: [
    PageHeightService,
    GlyphService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
