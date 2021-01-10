import { Component } from '@angular/core';

@Component({
  selector: 'ecom-session-layout',
  template: `
    <div class="container">
      <ecom-header [showActions]="false"></ecom-header>
      <main>
        <router-outlet></router-outlet>
      </main>
      <div></div>
    </div>
  `,
  styles: [
    `
      .container {
        width: 100%;
        height: 100%;
        flex-grow: 1;
        display: flex;
        flex-direction: column;
      }
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
export class SessionLayoutComponent {}
