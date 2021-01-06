import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Output,
} from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'ecom-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class LoginComponent {
  loginForm: FormGroup;
  @Output() registerRequested = new EventEmitter<void>();

  constructor(private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.loginForm.controls;
  }

  login() {
    alert('Pas encore implémenté !');
  }

  get emailErrorMessage() {
    if (this.f.email.hasError('required')) {
      return 'Ce champ est requis';
    }
    return this.f.email.hasError('email')
      ? 'Entrez un email valide. Example : mon.email@gmail.com'
      : '';
  }
  get passwordErrorMessage() {
    return this.f.password.hasError('required') ? 'Ce champ est requis' : '';
  }
}
