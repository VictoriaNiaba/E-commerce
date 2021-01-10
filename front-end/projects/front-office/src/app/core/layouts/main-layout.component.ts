import { Component } from '@angular/core';

@Component({
  selector: 'ecom-main-layout',
  template: `
    <ecom-header [showActions]="true" class="header"></ecom-header>
    <main>
      <router-outlet></router-outlet>
    </main>
    <ecom-footer></ecom-footer>
  `,
  styles: [
    `
      :host {
        display: flex;
        flex-direction: column;
        min-height: 100vh;
      }
      .header {
        position: sticky;
        position: -webkit-sticky; /* For macOS/iOS Safari */
        top: 0;
        z-index: 1000;
      }
      .example-container {
        flex-grow: 1;
        display: flex;
        flex-direction: column;
      }
      main {
        flex-grow: 1;
        display: flex;
        height: 100%;
      }
      .mat-drawer {
        width: 180px;
      }
      .mat-drawer-content {
        flex-grow: 1;
        display: flex;
        flex-direction: column;
      }
      .mat-drawer-container {
        background-color: inherit;
      }
    `,
  ],
})
export class MainLayoutComponent {}
