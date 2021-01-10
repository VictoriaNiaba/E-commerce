import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { InternalServerErrorComponent } from './containers/internal-server-error.component';
import { LoginAndRegisterComponent } from './containers/login-and-register.component';
import { NotFoundComponent } from './containers/not-found.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginAndRegisterComponent,
  },
  {
    path: '404',
    component: NotFoundComponent,
  },
  {
    path: '500',
    component: InternalServerErrorComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SessionsRoutingModule {}
