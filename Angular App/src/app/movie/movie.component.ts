import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { FavouriteService } from '../services/favourite.service';
import { LoginService } from '../services/login.service';

import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css'],
  providers: [NgbRatingConfig]
})
export class MovieComponent implements OnInit {
  carouselMovies: any[]=[];

  constructor( config: NgbRatingConfig, private movieService:MovieService,private routes:Router, private favouriteService:FavouriteService, public loginService:LoginService) {
    
    config.max = 10;
    config.readonly = true;
   }

  ngOnInit(): void {
    this.getMovies();
    
  }
 
  show:boolean;
 
    movieData:any;
  
    getMovies() {
      return this.movieService.getAllMovies().subscribe(response=> {
        this.movieData=response;
        console.log(this.movieData.length)
        for(let m of this.movieData) {
          // if(m.yearOfRelease==1999)
          if(m.rating>8.7) {
            console.log(m.rating)
          this.carouselMovies.push(m);
          }
        }
      })
      
    }
    
    addToFav(movieId: string) {
      console.log(movieId)
      console.log(this.loginService.userData.userId)
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
              alert("Duplicate")
            }
          
        }
        else {
          this.favouriteService.addToFavList(this.loginService.userData.userId, movieId).subscribe(response => {
            alert("Added to Favourites")
          })
        }
      })
  
  
    }
    play(m:any) {
      this.movieService.playMovie=m;
        this.routes.navigateByUrl('play');
      }
}
