import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from '../services/movie.service';
import { CategoryService } from './category.service';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  constructor(private cs: CategoryService, private routes: Router, private movieService: MovieService) { }

  ngOnInit(): void {
  }
  
  items: any = [
    { url: "/assets/comedy.jpg", figcaption: "Action" },
    { url: "/assets/romance.jpg", figcaption: "Comedy" },
    { url: "/assets/images.jpg", figcaption: "Drama" },
    { url: "/assets/horror.jpg", figcaption: "Adventure" },

  ];
  selectedgenre: any
  onselect(genre: any) {
    this.selectedgenre = genre;
    console.log(this.selectedgenre);
    this.cs.getongenre(this.selectedgenre).subscribe(response => {
      console.log(response);
      CategoryService.id = response;

    }
    )

  }

  play(m: any) {
    this.movieService.playMovie = m;
    this.routes.navigateByUrl('play');
  }
}
