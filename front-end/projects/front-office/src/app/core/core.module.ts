import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';

import { LayoutsModule } from '../layouts/layouts.module';
import { SessionsModule } from '../sessions/sessions.module';

@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  exports: [LayoutsModule, SessionsModule],
})
export class CoreModule {}
