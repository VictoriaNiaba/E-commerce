import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MaterialModule } from './modules/material.module';
import { FeatherModule } from './modules/feather.module';
import { FontAwesomeModule } from './modules/fontawesome.module';
import { ClickStopPropagationDirective } from './directives/click-stop-propagation.directive';

const DIRECTIVES = [ClickStopPropagationDirective];

const MODULES = [
  CommonModule,
  RouterModule,
  FormsModule,
  ReactiveFormsModule,

  MaterialModule,
  FeatherModule,
  FontAwesomeModule,
];

@NgModule({
  declarations: [...DIRECTIVES],
  imports: [...MODULES, ...DIRECTIVES],
  exports: [...MODULES, ...DIRECTIVES],
})
export class SharedModule {}
