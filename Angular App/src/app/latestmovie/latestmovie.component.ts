import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-latestmovie',
  templateUrl: './latestmovie.component.html',
  styleUrls: ['./latestmovie.component.css']
})
export class LatestmovieComponent implements OnInit {

  constructor(private movieService:MovieService, private routes:Router) { }
  movieData:any;
  latestMovie:any[]=[];
  latestdata:any[]=[];
  ngOnInit(): void {
    this.showlatest();
  }
showlatest()
{
  this.movieService.latestMovie.splice(0, this.movieService.latestMovie.length);
  this.movieService.getLatestMovies().subscribe(response=>{
    console.log(response);
  this.movieData=response;
for(let i=0;i<this.movieData.length;i++)
{
  this.movieService.latestMovie.push(this.movieData[i]);
  console.log("test1"+this.movieService.latestMovie);
}
console.log("test"+this.movieService.latestMovie);
this.getlatestbyid();
  })
  
  }

getlatestbyid()
{
  console.log("test method-------"+this.movieService.latestMovie);
  for(let i of this.movieService.latestMovie) {
  this.movieService.getLatestMoviesbyId(i).subscribe(response=>{
    console.log(response);
   
  this.latestdata.push(response);
  
}
  )
  }
  console.log("length-----"+this.latestdata.length);
}
play(m: any) {
  this.movieService.playMovie = m;
  this.routes.navigateByUrl('play');
}
}
