import { AfterViewInit, Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'ecom-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements AfterViewInit {
  loginForm: FormGroup;
  @Output() registerRequested = new EventEmitter<void>();
  @ViewChild('usernameInput') usernameInput: ElementRef | undefined;

  ngAfterViewInit() {
    this.usernameInput?.nativeElement.focus();
  }

  constructor(private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
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

  get usernameErrorMessage() {
    const username = this.f.username;
    return username.hasError('required') ? 'Ce champ est requis' : '';
  }
  get passwordErrorMessage() {
    const password = this.f.password;
    return password.hasError('required') ? 'Ce champ est requis' : '';
  }
}
