import { Component, Input, OnInit } from '@angular/core';

import { Product } from '../../model/product';

@Component({
  selector: 'ecom-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.scss'],
})
export class ProductsListComponent implements OnInit {
  @Input() products: Product[] = [];

  constructor() {}

  ngOnInit(): void {}
}
