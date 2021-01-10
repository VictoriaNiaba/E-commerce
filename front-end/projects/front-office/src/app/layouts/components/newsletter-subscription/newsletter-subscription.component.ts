import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'ecom-newsletter-subscription',
  templateUrl: './newsletter-subscription.component.html',
  styleUrls: ['./newsletter-subscription.component.scss'],
})
export class NewsletterSubscriptionComponent {
  newsletterSubscriptionForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.newsletterSubscriptionForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
    });
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.newsletterSubscriptionForm.controls;
  }
  get emailErrorMessage() {
    if (this.f.email.hasError('required')) {
      return 'Ce champ est requis';
    }
    return this.f.email.hasError('email')
      ? 'Entrez un email valide. Example : mon.email@gmail.com'
      : '';
  }
}
