import { Component } from '@angular/core';

@Component({
  selector: 'ecom-auth-layout',
  template: `
    <ecom-header [showActions]="false"></ecom-header>
    <main>
      <router-outlet></router-outlet>
    </main>
  `,
  styles: [
    `
      :host {
        display: flex;
        flex-direction: column;
        min-height: 100vh;
      }
      main {
        flex-grow: 1;
        display: flex;
        justify-content: center;
        padding-top: 2rem;
        height: 100%;
      }
    `,
  ],
})
export class AuthLayoutComponent {}
