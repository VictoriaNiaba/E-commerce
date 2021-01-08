import { Component, Input, OnInit } from '@angular/core';

export interface NavListItem {
  link: string;
  label: string;
}

@Component({
  selector: 'ecom-nav-list',
  template: `
    <mat-nav-list>
      <a
        mat-list-item
        [routerLink]="navListItem.link"
        *ngFor="let navListItem of navListItems"
      >
        {{ navListItem.label }}
      </a>
    </mat-nav-list>
  `,
  styles: [
    `
      .mat-list-base {
        padding-top: 0;
      }
      a {
        border-bottom: 1px solid rgba(0, 0, 0, 0.12);
        border-left: 3px solid white;
      }
      a:hover {
        border-left-color: black;
        border-bottom: 1px solid rgba(0, 0, 0, 0.12);
      }
    `,
  ],
})
export class NavListComponent implements OnInit {
  @Input() navListItems: NavListItem[] = [
    {
      label: 'Affiches',
      link: 'categories/affiches',
    },
    {
      label: 'Cadres',
      link: 'categories/cadres',
    },
    {
      label: 'Textiles',
      link: 'categories/textiles',
    },
    {
      label: 'Papeterie',
      link: 'categories/papeterie',
    },
    {
      label: 'Annonces',
      link: 'categories/annonces',
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
