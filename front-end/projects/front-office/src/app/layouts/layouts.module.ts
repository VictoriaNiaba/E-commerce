import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { BrandingComponent } from './components/branding.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { NavFooterComponent } from './components/nav-footer/nav-footer.component';
import { NavLocaleComponent } from './components/nav-locale.component';
import { NewsletterSubscriptionComponent } from './components/newsletter-subscription/newsletter-subscription.component';
import { SocialNetworksComponent } from './components/social-networks.component';
import { SubHeaderComponent } from './components/sub-header/sub-header.component';
import { SessionLayoutComponent } from './containers/session-layout.component';
import { MainLayoutComponent } from './containers/main-layout.component';

@NgModule({
  declarations: [
    // Dispositions (layouts)
    MainLayoutComponent,
    SessionLayoutComponent,

    // Composants utilisés dans les dispositions
    FooterComponent,
    HeaderComponent,
    NavFooterComponent,
    NewsletterSubscriptionComponent,
    SubHeaderComponent,
    BrandingComponent,
    NavLocaleComponent,
    SocialNetworksComponent
  ],
  imports: [SharedModule],
})
export class LayoutsModule {}
