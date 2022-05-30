import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  url1: string = "http://localhost:9003/movieapp/recom-movies/category/"
  constructor(private httpClient: HttpClient) { }
  static id: any;
  getongenre(genre: any) {
    return this.httpClient.get<any>(this.url1 + genre);
  }
}
