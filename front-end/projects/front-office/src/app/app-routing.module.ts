import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Error404Component } from './core/components/error404/error404.component';
import { LoginAndRegisterComponent } from './core/components/login-and-register.component';
import { AuthLayoutComponent } from './core/layouts/auth-layout.component';
import { MainLayoutComponent } from './core/layouts/main-layout.component';

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
    component: AuthLayoutComponent,
    children: [
      {
        path: 'login',
        component: LoginAndRegisterComponent,
      },
      { path: '**', component: Error404Component },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
