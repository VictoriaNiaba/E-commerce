import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Product } from '../model/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'ecom-category-detail-page',
  template: `
    <div>
      <div
        class="container-fluid"
        style="width: 100%; margin-top: 1rem; padding: 0 2rem"
      >
        <mat-hint style="font-size: 11px; letter-spacing: 0.04rem;"
          >Accueil - Livres</mat-hint
        >
        <h2
          style="font-weight: 500; margin-top:0.5rem; text-transform: uppercase"
        >
          Livres
        </h2>
      </div>
      <ecom-carousel></ecom-carousel>
      <ecom-reassurance></ecom-reassurance>

      <div
        class="container-fluid"
        style="width: 100%; padding: 2rem"
      >
        <h2
          style="font-weight: 500; text-transform: uppercase; margin:0"
        >
          Les mieux notés
        </h2>
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
