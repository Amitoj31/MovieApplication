import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/category/category.service';
import { MovieService } from 'src/app/services/movie.service';
import { SelectedService } from './selected.service';

@Component({
  selector: 'app-selected',
  templateUrl: './selected.component.html',
  styleUrls: ['./selected.component.css']
})
export class SelectedComponent implements OnInit {
  carouselMovies: any[]=[];
  constructor(private cs:CategoryService,private sel:SelectedService,private routes:Router, private movieService:MovieService ) { }

  ngOnInit(): void {
    this.getMovies();
  }
  movieData:any[]=[];
  ids:any;
  getMovies() {
  
      for(let i of CategoryService.id) {
      
          this.sel.getAllMovies(i).subscribe(response=>{
            console.log(response)
            this.movieData.push(response)
            //console.log(this.movieData.length)
          })
      }
     
   
      }

      play(m: any) {
        this.movieService.playMovie = m;
        this.routes.navigateByUrl('play');
      }
    
}
