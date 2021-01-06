import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  filteredEntities$: Observable<Product[]> = of([
    {
      id: '1',
      title: 'Playstation 5',
      description: 'Playstation 5',
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2018/03/REGLES-CRECHE-1.jpg',
    },
    {
      id: '2',
      title: 'IPhone XS',
      description: 'Playstation 5',
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2019/03/ROSE-PALE-RECTO-600x600.jpg',
    },
    {
      id: '3',
      title: 'Pixel 4a',
      description: 'Playstation 5',
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2017/09/AFFICHE-NAISSANCE-GARS-GRIS.jpg',
    },
    {
      id: '4',
      title: 'Galaxy Tab S5e',
      description: 'Playstation 5',
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2017/07/CHEZ-PAPI-ET-MAMIE.jpg',
    },
    {
      id: '5',
      title: 'Pocophone F1',
      description: 'Playstation 5',
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2018/06/LES-REGLES-DE-LA-SDJ-600X600.jpg',
    },
    {
      id: '6',
      title: 'Pocophone F1',
      description: 'Playstation 5',
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2018/06/LES-REGLES-DE-LA-SDJ-600X600.jpg',
    },
    {
      id: '7',
      title: 'Pocophone F1',
      description: 'Playstation 5',
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2018/06/LES-REGLES-DE-LA-SDJ-600X600.jpg',
    },
    {
      id: '8',
      title: 'Pocophone F1',
      description: 'Playstation 5',
      image:
        'https://www.lapoupetteapaillettes.com/wp-content/uploads/2018/06/LES-REGLES-DE-LA-SDJ-600X600.jpg',
    }
  ]);
  entities$: any;

  getAll(categoryId: string) {
    throw new Error('Method not implemented.');
  }

  getEntityFromCache(id: any): import('rxjs').Observable<any> {
    throw new Error('Method not implemented.');
  }

  constructor() {}
}
