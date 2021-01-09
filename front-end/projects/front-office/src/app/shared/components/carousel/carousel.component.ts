import { AfterViewInit, Component, Input } from '@angular/core';
import * as $ from 'jquery';

export interface CarouselItem {
  image: string;
  backgroundColor: string;
  action: {
    label: string;
    position: 'bottom-left' | 'bottom-right' | 'top-left' | 'top-right';
  };
  link: string;
}

@Component({
  selector: 'ecom-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss'],
})
export class CarouselComponent implements AfterViewInit {
  @Input() carouselItems: CarouselItem[] = [
    {
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2018/11/CARTES-BANNIERE-SITE-1-1030x360_c.jpg',
      backgroundColor: '#e7e7e7',
      action: { label: 'Je découvre', position: 'bottom-left' },
      link: '/login',
    },
    {
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2018/11/AFFICHES-NOEL-1030x360_c.jpg',
      backgroundColor: '#cf9a4a',
      action: { label: 'Je découvre', position: 'bottom-right' },
      link: '/login',
    },
  ];

  ngAfterViewInit(): void {
    var $jq = jQuery.noConflict();

    $jq(document).ready(function () {
      ($jq('.carousel-content') as any).slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 4000,
        accessibility: true,
        prevArrow: $('.carousel-prev'),
        nextArrow: $('.carousel-next'),
        dots: true,
      });
    });
  }
}
