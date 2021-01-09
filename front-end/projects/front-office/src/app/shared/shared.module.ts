import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MaterialModule } from './modules/material.module';
import { FeatherModule } from './modules/feather.module';
import { FontAwesomeModule } from './modules/fontawesome.module';
import { ClickStopPropagationDirective } from './directives/click-stop-propagation.directive';
import { ReassuranceComponent } from './components/reassurance/reassurance.component';
import { CarouselComponent } from './components/carousel/carousel.component';

const DIRECTIVES = [ClickStopPropagationDirective];

const COMPONENTS = [ReassuranceComponent, CarouselComponent];

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
  declarations: [...DIRECTIVES, ...COMPONENTS],
  imports: [...MODULES],
  exports: [...MODULES, ...DIRECTIVES, ...COMPONENTS],
})
export class SharedModule {}
