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
import { Error404Component } from './components/error404/error404.component';
import { FooterComponent } from './components/footer/footer.component';
import {A11yModule} from '@angular/cdk/a11y';
import { NewsletterSubscriptionComponent } from './components/newsletter-subscription/newsletter-subscription.component';
import { SocialNetworksComponent } from './components/social-networks.component';
import { NavFooterComponent } from './components/nav-footer/nav-footer.component';
import { NavLocaleComponent } from './components/nav-locale.component';
import { NavListComponent } from './components/nav-list/nav-list.component';

@NgModule({
  declarations: [
    Error404Component,
    MainLayoutComponent,
    AuthLayoutComponent,
    LoginComponent,
    BrandingComponent,
    HeaderComponent,
    RegisterComponent,
    LoginAndRegisterComponent,
    FooterComponent,
    NewsletterSubscriptionComponent,
    SocialNetworksComponent,
    NavFooterComponent,
    NavLocaleComponent,
    NavListComponent,
  ],
  imports: [
    SharedModule,
    FeatherModule,
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule,
    A11yModule
  ],
})
export class CoreModule {}
