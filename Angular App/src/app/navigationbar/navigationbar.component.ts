import { Component, OnInit  } from '@angular/core';
import { BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { MovieService } from '../services/movie.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-navigationbar',
  templateUrl: './navigationbar.component.html',
  styleUrls: ['./navigationbar.component.css']
})
export class NavigationbarComponent {

  // mobileQuery: MediaQueryList;
  // show:boolean=true;
  // showN() {
  //   this.show=!this.show;
  // }
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  

  constructor( private breakpointObserver: BreakpointObserver, private movieService:MovieService, public loginService:LoginService) {
    
  
  }
  ngOnInit(): void {
    this.checkStatus();
  }
 
  searchtext:any;
  moviearray:any;
  storemoive:any[]=[];
  // storemovieobject:any[]=[];
  search(searchtext:any) {
    console.log("ans"+this.storemoive.length);
    this.storemoive.splice(0, this.storemoive.length);
    this.movieService.storemovieobject.splice(0, this.movieService.storemovieobject.length);
      console.log(this.storemoive.length);
    this.movieService.getMoviebyFirstLetter(searchtext).subscribe(res=>{
      console.log(res)
      this.moviearray=res;
      console.log(this.moviearray.length);
      for (let i = 0; i < this.moviearray.length; i++){
        this.storemoive.push(this.moviearray[i].movieName);
        this.movieService.storemovieobject.push(this.moviearray[i]);
        // console.log(this.storemoive);
      }
      console.log(this.storemoive.length);
    })
  }
  loggedIn:boolean=false;
  profilePic:string;
  checkStatus() {
    this.loggedIn=this.loginService.isLoggedin;
    console.log(this.loggedIn);
  }
  logout() {
    this.loginService.isLoggedin=false;
  }
  
}
