import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FavouriteService } from 'src/app/services/favourite.service';
import { LoginService } from 'src/app/services/login.service';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit {

  constructor(private movieService: MovieService, private routes:Router, private favouriteService:FavouriteService, private loginService:LoginService) { 
    this.displayMovie();
  }

  ngOnInit(): void {
   
  }
  movie: any;
  playOn:any;
  displayMovie() {
    this.movie = this.movieService.playMovie;
    if(this.movie==null || this.movie==undefined) {
      this.routes.navigateByUrl("movie");
    }
   
  }
  back() {
    this.routes.navigateByUrl('movie');
  }
  play() {
    this.playOn=true;
      }
  addCheck() {
    if(this.loginService.isLoggedin==false) {
      this.routes.navigateByUrl('login')
      alert("Please Login First To use this feature")
    }
    else {
    this.addToFav(this.movie.movieId);
    }
  }
  addToFav(movieId: string) {
    // console.log(movieId)
    // console.log(this.loginService.userData.userId)
    this.favouriteService.getFavList(this.loginService.userData.userId).subscribe(response => {
      let flag = true;
      if (response != null) {
        let ids = response;
        for (let i = 0; i < ids.length; i++) {
          console.log(ids[i])
          if (ids[i] == movieId) {
            flag = false;
          }
        }
        if(flag == true) {
          this.favouriteService.addToFavList(this.loginService.userData.userId, movieId).subscribe(response => {
            alert("Added to Favourites")
          })
        }
          else {
            alert("Already In favourites")
          }
        
      }
      else {
        this.favouriteService.addToFavList(this.loginService.userData.userId, movieId).subscribe(response => {
          alert("Added to Favourites")
        })
      }
    })
  }
 
}
