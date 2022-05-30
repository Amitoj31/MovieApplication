import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginService } from './login.service';




@Injectable({
  providedIn: 'root'
})
export class FavouriteService {

  constructor(private httpClient:HttpClient, private loginService:LoginService) { }
  favouriteUrl="http://localhost:9001/movieapp/user-fav/fav";
  
  getFavList(id:any) {
    let  reqHeader=new HttpHeaders().set('Authorization',this.loginService.token)
   return this.httpClient.get<any>(this.favouriteUrl+"/"+id, {headers:reqHeader});
  }
  addToFavList(id:number,m:string) {
    console.log(this.loginService.token)
   let  reqHeader=new HttpHeaders().set('Access-Control-Allow-Origin','*').set('Authorization',this.loginService.token)
   return this.httpClient.put<any>(this.favouriteUrl+"/"+id, m, {headers:reqHeader});
  }
  delFromList(id:any) {
    let  reqHeader=new HttpHeaders().set('Access-Control-Allow-Origin','*').set('Authorization',this.loginService.token)
    return this.httpClient.delete<any>(this.favouriteUrl+"/"+this.loginService.userData.userId +"/"+id, {headers:reqHeader});
  }
}
