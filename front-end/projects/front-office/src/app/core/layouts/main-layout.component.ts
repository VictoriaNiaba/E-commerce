import { Component } from '@angular/core';

@Component({
  selector: 'ecom-main-layout',
  template: `
    <ecom-header [showActions]="true"></ecom-header>
    <main>
      <router-outlet></router-outlet>
    </main>
  `,
  styles: [
    `
      :host {
        display: flex;
        flex-direction: column;
        height: 100%;
      }
      main {
        display: flex;
        justify-content: center;
        padding-top: 2.5rem;
        height: 100%;
      }
    `,
  ],
})
export class MainLayoutComponent {}
