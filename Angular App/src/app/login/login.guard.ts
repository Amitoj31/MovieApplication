import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../services/login.service';



@Injectable({
  providedIn: 'root'
})

export class LoginGuard implements CanActivate {
  constructor(private loginservice:LoginService,private router:Router)
  {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.guardfavourite(state.url);
  }
  guardfavourite(url:string)
  {
    if(this.loginservice.isLoggedin==true)
    {
    console.log("Authentication done");
 
    return true;
    
    }
    else
    {
console.log("Authentication NOT DONE");
return this.router.parseUrl('/login');
    }

  }

}
