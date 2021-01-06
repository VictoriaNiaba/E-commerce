import { Component } from '@angular/core';

@Component({
  selector: 'ecom-nav-locale',
  template: `
    <mat-hint>
      <span>© 2021 SICHOU Tous droits réservés</span>
      <a class="link-without-underline">Politique de Confidentialité</a> |
      <a class="link-without-underline">CGV</a>
    </mat-hint>
  `,
  styles: [
    `
      .mat-hint {
        font-size: 12px;
        margin: 33.1px 0 10px;
      }
      span {
        margin-right: 1rem;
      }
    `,
  ],
})
export class NavLocaleComponent {}
