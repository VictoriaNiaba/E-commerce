import { Component } from '@angular/core';
import { IconName } from '@fortawesome/fontawesome-svg-core';

@Component({
  selector: 'ecom-social-networks',
  template: `
    <div class="social-networks-container">
      <a
        mat-icon-button
        [matTooltip]="socialNetwork.label"
        *ngFor="let socialNetwork of socialNetworks"
        color="primary"
        [href]="socialNetwork.link"
        attr.aria-label="{{ socialNetwork.label }} button"
      >
        <fa-icon [icon]="['fab', socialNetwork.icon]" size="lg"></fa-icon>
      </a>
    </div>
  `,
  styles: [
    `
      .social-networks-container {
        margin: 15.6px 0 33.1px;
      }
    `,
  ],
})
export class SocialNetworksComponent {
  socialNetworks: { label: string; icon: IconName; link: string }[] = [
    {
      label: 'Facebook',
      icon: 'facebook-f',
      link: 'https://www.facebook.com/',
    },
    {
      label: 'Instagram',
      icon: 'instagram',
      link: 'https://www.instagram.com/sichou_creation/',
    },
    {
      label: 'Pinterest',
      icon: 'pinterest-p',
      link: 'https://www.pinterest.fr/',
    },
  ];
}
