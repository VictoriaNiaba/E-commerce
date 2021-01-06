import { Component } from '@angular/core';

interface NavFooterItem {
  label: string;
  link: string;
  external: boolean;
}

@Component({
  selector: 'ecom-nav-footer',
  templateUrl: './nav-footer.component.html',
  styleUrls: ['./nav-footer.component.scss'],
})
export class NavFooterComponent {
  navItems: NavFooterItem[] = [
    {
      label: 'Aide',
      link: '',
      external: false,
    },
    {
      label: 'Qui sommes-nous ?',
      link: '',
      external: false,
    },
    {
      label: 'Retours',
      link: '',
      external: false,
    },
    {
      label: 'Kit de presse',
      link: '',
      external: false,
    }
  ];
}
