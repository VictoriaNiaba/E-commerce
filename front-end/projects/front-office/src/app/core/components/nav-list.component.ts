import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../../features/category/model/category';
import { CategoryService } from '../../features/category/services/category.service';

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
        *ngFor="let navListItem of navListItems"
        [routerLink]="navListItem.link"
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
  navListItems: NavListItem[] = [];

  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    const categories$: Observable<
      Category[]
    > = this.categoryService.getAllCategories();

    categories$.subscribe((categories) => {
      this.navListItems = this.categoriesToNavListItems(categories);
    });
  }

  private categoriesToNavListItems(categories: Category[]): NavListItem[] {
    const navListCategories: NavListItem[] = [];

    categories.forEach((category) => {
      navListCategories.push({
        label: category.title,
        link: 'categories/' + category.id,
      });
    });

    return navListCategories;
  }
}
