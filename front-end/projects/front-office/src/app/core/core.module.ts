import { NgModule } from '@angular/core';
import { MainLayoutComponent } from './layouts/main-layout.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { AuthLayoutComponent } from './layouts/auth-layout.component';
import { SharedModule } from '../shared/shared.module';
import { FeatherModule } from 'angular-feather';
import { LoginComponent } from './components/login/login.component';
import { BrandingComponent } from './components/branding.component';
import { HeaderComponent } from './components/header/header.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginAndRegisterComponent } from './components/login-and-register.component';

@NgModule({
  declarations: [
    MainLayoutComponent,
    AuthLayoutComponent,
    LoginComponent,
    BrandingComponent,
    HeaderComponent,
    RegisterComponent,
    LoginAndRegisterComponent,
  ],
  imports: [
    SharedModule,
    FeatherModule,
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule,
  ],
})
export class CoreModule {}
