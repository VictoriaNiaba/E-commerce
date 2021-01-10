import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Category } from '../model/category';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  constructor(private http: HttpClient) {}

  /**
   * Retourne l'ensemble des catégories, extraites à partir du back-end.
   */
  getAllCategories(): Observable<Category[]> {
    const response$: Observable<any> = this.http.get(
      'http://localhost:8080/api/categories/'
    );

    // Filtrage des métadonnées de pagination, inutiles dans ce cas.
    const categories$: Observable<Category[]> = response$.pipe(
      map((response) => response.content)
    );

    return categories$;
  }
}
