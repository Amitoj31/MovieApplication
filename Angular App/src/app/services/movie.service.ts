import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private httpClient: HttpClient) { }
movieUrl="http://localhost:9002/movieapp/movies/movie";

  //properMovies:any[]=[];
  storemovieobject:any[]=[];
  latestMovie:any[]=[];
  playMovie: any;
  getAllMovies() {
    return this.httpClient.get(this.movieUrl);
  }
 
  getMovieById(id:any) {
    return this.httpClient.get("http://localhost:9002/movieapp/movies/movie-byId/"+id)
  }
  getMoviebyFirstLetter(name:any) {
    if(isNaN(name))
    {
    return this.httpClient.get("http://localhost:9002/movieapp/movies/movie-byFirstLetter/"+name)
    }
    else
    {
      return this.httpClient.get("http://localhost:9003/movieapp/recom-movies/year/"+name)
    }
  }

  getLatestMovies()
  {
    return this.httpClient.get<any>("http://localhost:9003/movieapp/recom-movies/latest")
  }
  getLatestMoviesbyId(id:any)
  {
    console.log("idtest"+id);
    return this.httpClient.get("http://localhost:9002/movieapp/movies/movie-byId/"+id)
  }
}
