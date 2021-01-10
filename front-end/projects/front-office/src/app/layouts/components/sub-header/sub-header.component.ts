import { Component, Input } from '@angular/core';

export interface NavListItem {
  link: string;
  label: string;
}

@Component({
  selector: 'ecom-sub-header',
  template: `
    <nav>
      <ul>
        <li *ngFor="let navListItem of navListItems">
          <a [routerLink]="navListItem.link" class="link-without-underline">
            {{ navListItem.label }}
          </a>
        </li>
      </ul>
    </nav>
  `,
  styleUrls: ['./sub-header.component.scss']
})
export class SubHeaderComponent {
  @Input() navListItems: NavListItem[] = [];
}
