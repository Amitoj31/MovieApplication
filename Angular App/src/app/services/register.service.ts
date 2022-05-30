import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  url:string="http://localhost:8081/movieapp/authuser/user";
  constructor(private httpClient:HttpClient) { }
  reqHeader=new HttpHeaders().set('Access-Control-Allow-Origin','*')
                    .set('Access-Control-Aloow-Methods',['POST', 'PATCH', 'PUT', 'DELETE', 'OPTIONS'])
                    .set('Access-Control-Allow-Headers', ['Origin', 'Content-Type']);
  saveUser(data:any){
    
   
    return this.httpClient.post<any>(this.url,data,{ headers:this.reqHeader } );  
  }
  deleteUser(id:any){
    return this.httpClient.delete<any>("http://localhost:8081/movieapp/authuser/user/"+id);
  }
}
