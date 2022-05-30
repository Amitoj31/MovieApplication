import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CategoryService } from 'src/app/category/category.service';

@Injectable({
  providedIn: 'root'
})
export class SelectedService {
  
  movieUrl="http://localhost:9002/movieapp/movies/movie-byId/";
  constructor(private httpClient:HttpClient,private cs: CategoryService) { }
  getAllMovies(id:any) {
    // console.log(this.movieUrl+id);
    return this.httpClient.get<any>(this.movieUrl+id);
  
  }
}
