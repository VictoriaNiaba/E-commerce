import { Component } from '@angular/core';

@Component({
  selector: 'ecom-branding',
  template: `
    <a class="branding" [routerLink]="['/']">
      <h1 class="branding-title">Sichou<span class="branding-dot">.</span></h1>
    </a>
  `,
  styles: [
    `
      .branding {
        color: inherit;
        text-decoration: inherit;
      }
      .branding-title {
        padding-bottom: 0.5rem;
      }
      .branding-dot {
        font-size: 35px;
        color: #cd5280;
      }
    `,
  ],
})
export class BrandingComponent {}
