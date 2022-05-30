import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private movieService:MovieService, private routes:Router) { }
  movieData:any[]=[];
  ngOnInit(): void {
    this.movieData=this.movieService.storemovieobject
  }
  show:boolean;
  play(m: any) {
    this.movieService.playMovie = m;
    this.routes.navigateByUrl('play');
  }
}
