
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { FavouriteService } from '../services/favourite.service';
import { LoginService } from '../services/login.service';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {

  constructor(config: NgbRatingConfig, private loginService: LoginService,private routes:Router, private favouriteService: FavouriteService, private movieService: MovieService) {
    config.max = 10;
    config.readonly = true;
   }

  ngOnInit(): void {
    this.getFavList();
  }

  show: boolean;
  favList: any;
  arr: any;
  favMovies: any[] = [];

  getFavList() {
    this.favouriteService.getFavList(this.loginService.userData.userId).subscribe(response => {
      console.log(response)
      this.favList = response;
      this.favMovies = [];
      for (let f of this.favList) {
        console.log(f);
        this.getMoviesById(f);
      }
    })
  }
  getMoviesById(id: any) {
    this.movieService.getMovieById(id).subscribe(response => {
      console.log(response)
      this.favMovies.push(response);
    })
  }
  removeFromFavourite(id: any) {
    this.favouriteService.delFromList(id).subscribe(response => {
      this.getFavList();
    })
  }

  play(m:any) {
    this.movieService.playMovie=m;
      this.routes.navigateByUrl('play');
    }
}
