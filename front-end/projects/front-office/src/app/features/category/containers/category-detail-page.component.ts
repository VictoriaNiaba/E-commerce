import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Product } from '../model/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'ecom-category-detail-page',
  template: `
    <div class="container-fluid" style="width: 100%">
      <h2>Affiches</h2>

      <ecom-products-list
        [products]="(products$ | async) || []"
      ></ecom-products-list>
    </div>
  `,
  styles: [
    `
      :host {
        width: 100%;
      }
    `,
  ],
})
export class CategoryDetailPageComponent implements OnInit {
  products$: Observable<Product[]>;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
  ) {
    this.products$ = this.productService.filteredEntities$;
  }

  ngOnInit(): void {
    this.route.params
      .pipe(map((params) => params.id))
      .subscribe((id) => this.productService.getAll(id)); // TODO: unsub
  }
}
