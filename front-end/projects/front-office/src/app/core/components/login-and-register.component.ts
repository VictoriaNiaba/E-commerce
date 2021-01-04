import { Component } from '@angular/core';

@Component({
  selector: 'ecom-login-and-register',
  template: `
    <mat-tab-group mat-align-tabs="center" [(selectedIndex)]="tabIndex">
      <mat-tab label="Démarrez la session">
        <ecom-login (registerRequested)="tabIndex = 1"></ecom-login>
      </mat-tab>

      <mat-tab label="Inscrivez-vous">
        <ecom-register></ecom-register>
      </mat-tab>
    </mat-tab-group>
  `,
  styles: [
    `
      :host {
        width: 100%;
      }
      ::ng-deep .mat-tab-body-wrapper,
      .mat-tab-group {
        height: 100%;
        width: 100%;
        padding-top: 2rem;
      }
      ::ng-deep .mat-tab-header {
        border-color: rgba(0, 0, 0, 0.05);
      }
    `,
  ]
})
export class LoginAndRegisterComponent {
  tabIndex = 0;
}
