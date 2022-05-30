import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
isLoggedin:boolean=false;
  constructor(private httpClient : HttpClient) { }
  userData:any;
  url:string="http://localhost:8081/movieapp/authuser/login";
  token:string;

  login(data:any) {
    console.log(data)
   return  this.httpClient.post<any>(this.url,data , { headers : new HttpHeaders().set('Access-Control-Allow-Origin','*')});
  }

  validateLogin(id:any,token:any) {
    this.token=token;
  this.httpClient.get<any>("http://localhost:9001/movieapp/user-fav/user/"+id).subscribe(response=> {
     this.userData=response;
     this.isLoggedin=true;
     console.log("userdata"+this.userData.email)
   });
   
  }
   
  
  logincheck(email: string) {
    console.log("Email"+email);
  
    console.log("uDEmail"+this.userData.email);
    if(email==this.userData.email)
    {
      this.isLoggedin=true;
//alert('user logged in');
    }
    else
    {
      this.isLoggedin=false;
      alert('login failed');

    }
  }
}


   