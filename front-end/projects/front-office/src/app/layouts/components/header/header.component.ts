import { Component, Input } from '@angular/core';

@Component({
  selector: 'ecom-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  @Input() showActions = true;
}
