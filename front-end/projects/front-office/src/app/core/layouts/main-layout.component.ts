import { Component } from '@angular/core';

@Component({
  selector: 'ecom-main-layout',
  template: `
    <ecom-header [showActions]="true" class="header"></ecom-header>

    <mat-drawer-container class="example-container">
      <mat-drawer mode="side" opened>Drawer content</mat-drawer>
      <mat-drawer-content>
        <main>
          <router-outlet></router-outlet>
        </main>
        <ecom-footer></ecom-footer
      ></mat-drawer-content>
    </mat-drawer-container>
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
      main {
        flex-grow: 1;
        display: flex;
        height: 100%;
      }
      .mat-drawer {
        width: 200px;
      }
      .mat-drawer-container {
        background-color: inherit;
      }
    `,
  ],
})
export class MainLayoutComponent {}
