import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Product } from '../model/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'ecom-category-detail-page',
  template: `
    <mat-divider></mat-divider>
    <div>
      <div class="container-fluid section-header">
        <mat-hint class="breadcrumb">Accueil - Livres</mat-hint>
        <h2 class="section-title">Livres</h2>
      </div>
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
      .breadcrumb {
        font-size: 11px;
        letter-spacing: 0.04rem;
      }
      .section-title {
        margin-top: 0.5rem;
      }
      .section-header {
        width: 100%;
        margin-top: 1rem;
        padding: 0 2rem;
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
