import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { RegisterService } from '../services/register.service';


@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {
profilePic:any;
firstName:any;
lastName:any;
email:any;
contactno:any;
age:any;
userId:any;
  constructor( private loginService:LoginService,private router:Router, private registerService:RegisterService) { }
  userRecords:any;
  ngOnInit(): void {
    
    this.showUserProfile();
  }

  showUserProfile()
  {
 
    this.userRecords=this.loginService.userData;
      // for(var i=0;i<this.userRecords.length;i++){
        //this.userRecords[i].profilePic='data:image/jpeg;base64,' +this.userRecords[i].profilePic;
        this.profilePic=this.userRecords.profilePic;
        this.firstName=this.userRecords.firstName;
        this.lastName=this.userRecords.lastName;
        this.email=this.userRecords.email;
        this.contactno=this.userRecords.contactNo;
        this.age=this.userRecords.age;
        console.log("test"+this.profilePic);
        this.userId= this.userRecords.userId;
      }

    
  
  //     // for(let i=0;i<response.length;i++)
  //     // {
  //     // console.log('response : ' + response);
  //     // console.log('response : ' + response[i].firstName);
  //     // console.log('response : ' + response[i].profilePic);
  //     // this.userRecords=response;
  //     // this.profilepic=response.profilePic.toString().trim(";").get[0];
  //     // }
  //   })     
  // }
// constructor(private us:UserprofileService,) { }

// ngOnInit(): void {
//     }

//      //items:any=[{url:[figcaption,"/assets/romance.jpg"],figcaption:["comedy,romance"]}];
   
   
//     items :any= [
//        {url: "/assets/comedy.jpg", figcaption:"comedy"},
//               {url: "/assets/romance.jpg", figcaption:"romance"},
//               {url: "/assets/images.jpg", figcaption:"drama"},
//               {url: "/assets/horror.jpg", figcaption:"horror"},
      
//     ];
//     selectedgenre:any
//     onselect(genre:any)
//     {
// this.selectedgenre=genre;
// console.log(this.selectedgenre);
// this.us.getongenre(this.selectedgenre).subscribe( response=>{
//   console.log(response);
// }
// )
//     }

show:boolean=false;
     
      deleteshowbutton:boolean=false;
deleteShow(){
  this.show=true;
  this.deleteshowbutton=true;
}
      delete(){
          this.registerService.deleteUser(this.userId).subscribe(response=> {

            console.log(response);
this.router.navigate(['/login']);
        }) 
    }
    cancel(){
      this.show=false;
    }
  
    }
