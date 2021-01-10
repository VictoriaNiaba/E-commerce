import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Category } from '../../features/category/model/category';
import { CategoryService } from '../../features/category/services/category.service';
import { NavListItem } from '../components/sub-header/sub-header.component';

@Component({
  selector: 'ecom-main-layout',
  template: `
    <div class="container">
      <ecom-header [showActions]="true" class="header"></ecom-header>
      <ecom-sub-header
        class="sub-header"
        [navListItems]="(navListItems$ | async) || []"
      ></ecom-sub-header>
      <main>
        <router-outlet></router-outlet>
      </main>
      <ecom-footer></ecom-footer>
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
      .header {
        position: sticky;
        position: -webkit-sticky; /* For macOS/iOS Safari */
        top: 0;
        z-index: 1000;
      }
      .sub-header {
        display: flex;
        justify-content: center;
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
export class MainLayoutComponent {
  navListItems$: Observable<NavListItem[]>;

  constructor(private categoryService: CategoryService) {
    const categories$ = this.categoryService.getAllCategories();
    this.navListItems$ = categories$.pipe(map(this.toNavListItems));
  }

  /**
   * Converti un ensemble de catégories en un ensemble de liens.
   *
   * @param categories les catégories à convertir
   * @returns un ensemble de liens.
   */
  private toNavListItems(categories: Category[]): NavListItem[] {
    const navListItems: NavListItem[] = [];

    categories.forEach((category) => {
      navListItems.push({
        label: category.title,
        link: 'categories/' + category.id,
      });
    });

    return navListItems;
  }
}
