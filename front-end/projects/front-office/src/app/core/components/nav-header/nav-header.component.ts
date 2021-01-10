import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../../../features/category/model/category';
import { CategoryService } from '../../../features/category/services/category.service';

export interface NavListItem {
  link: string;
  label: string;
}

@Component({
  selector: 'ecom-nav-header',
  templateUrl: './nav-header.component.html',
  styleUrls: ['./nav-header.component.scss']
})
export class NavHeaderComponent implements OnInit {
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
