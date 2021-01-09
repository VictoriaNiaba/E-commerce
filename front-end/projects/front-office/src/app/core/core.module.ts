import { NgModule } from '@angular/core';
import { MainLayoutComponent } from './layouts/main-layout.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { BrandingComponent } from './components/branding.component';
import { HeaderComponent } from './components/header/header.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginAndRegisterComponent } from './components/login-and-register.component';
import { A11yModule } from '@angular/cdk/a11y';
import { SharedModule } from '../shared/shared.module';
import { Error404Component } from './components/error404/error404.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavFooterComponent } from './components/nav-footer/nav-footer.component';
import { NavLocaleComponent } from './components/nav-locale.component';
import { NavListComponent } from './components/nav-list.component';
import { NewsletterSubscriptionComponent } from './components/newsletter-subscription/newsletter-subscription.component';
import { SocialNetworksComponent } from './components/social-networks.component';
import { AuthLayoutComponent } from './layouts/auth-layout.component';

@NgModule({
  declarations: [
    Error404Component,
    LoginComponent,
    MainLayoutComponent,
    AuthLayoutComponent,
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
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule,
    A11yModule,
  ],
})
export class CoreModule {}
