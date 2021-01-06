import { Component, Input, OnInit } from '@angular/core';

import { Product } from '../../model/product';

@Component({
  selector: 'ecom-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss'],
})
export class ProductCardComponent implements OnInit {
  @Input() product: Product | undefined;
  cardRippleDisabled = false;

  constructor() {}

  ngOnInit(): void {}
}
