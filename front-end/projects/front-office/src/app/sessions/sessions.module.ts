import { NgModule } from '@angular/core';
import { A11yModule } from '@angular/cdk/a11y';

import { SessionsRoutingModule } from './sessions-routing.module';
import { ErrorCodeComponent } from './components/error-code/error-code.component';
import { SharedModule } from '../shared/shared.module';
import { NotFoundComponent } from './containers/not-found.component';
import { InternalServerErrorComponent } from './containers/internal-server-error.component';
import { LoginAndRegisterComponent } from './containers/login-and-register.component';
import { LoginComponent } from './containers/login/login.component';
import { RegisterComponent } from './containers/register/register.component';

@NgModule({
  declarations: [
    ErrorCodeComponent,
    NotFoundComponent,
    InternalServerErrorComponent,
    LoginAndRegisterComponent,
    LoginComponent,
    RegisterComponent,
  ],
  imports: [SharedModule, SessionsRoutingModule, A11yModule],
})
export class SessionsModule {}
