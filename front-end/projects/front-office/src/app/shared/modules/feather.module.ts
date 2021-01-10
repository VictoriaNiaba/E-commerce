import { NgModule } from '@angular/core';
import { FeatherModule as AngularFeatherModule } from 'angular-feather';

/* --------------- Usage : <i-feather name="eye"></i-feather> --------------- */

import {
  ShoppingCart,
  User,
  X,
  Plus,
  ChevronLeft,
  ChevronRight,
} from 'angular-feather/icons';

// Select some icons (use an object, not an array)
const icons = {
  ShoppingCart,
  User,
  X,
  Plus,
  ChevronLeft,
  ChevronRight,
};

@NgModule({
  imports: [AngularFeatherModule.pick(icons)],
  exports: [AngularFeatherModule],
})
export class FeatherModule {}
