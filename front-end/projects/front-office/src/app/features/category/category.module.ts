import { NgModule } from '@angular/core';

import { CategoryDetailPageComponent } from './containers/category-detail-page.component';
import { ProductsListComponent } from './components/products-list/products-list.component';
import { CategoryRoutingModule } from './category-routing.module';
import { SharedModule } from '../../shared/shared.module';
import { ProductCardComponent } from './components/product-card/product-card.component';

@NgModule({
  declarations: [CategoryDetailPageComponent, ProductsListComponent, ProductCardComponent],
  imports: [CategoryRoutingModule, SharedModule],
})
export class CategoryModule {}
