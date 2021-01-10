import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SessionLayoutComponent } from './layouts/containers/session-layout.component';
import { MainLayoutComponent } from './layouts/containers/main-layout.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      {
        path: 'home',
        loadChildren: () =>
          import('./features/home/home.module').then((m) => m.HomeModule),
      },
      {
        path: 'categories',
        loadChildren: () =>
          import('./features/category/category.module').then(
            (m) => m.CategoryModule
          ),
      },
    ],
  },
  {
    path: '',
    component: SessionLayoutComponent,
    children: [
      {
        path: 'sessions',
        loadChildren: () =>
          import('./sessions/sessions.module').then((m) => m.SessionsModule),
      },
    ],
  },
  { path: '**', redirectTo: 'sessions/404' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
