import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  constructor(private registerService:RegisterService,private router:Router) { }

  ngOnInit(): void {
  }

  emailPattern=/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/
  profileForm = new FormGroup({  
    firstName:new FormControl('',Validators.required),
    lastName:new FormControl('',Validators.required),
    email:new FormControl('',[Validators.required,Validators.minLength(3)]),
    contactNo:new FormControl('',Validators.required),
    password:new FormControl('',[Validators.required,Validators.minLength(3)]),
    profilePic:new FormControl(''),
    age:new FormControl('',Validators.required)
  });

  sendUserData():void
  {
   
    this.profileForm.patchValue({
      profilePic:this.url
    })
    console.log(this.profileForm.get('profilePic').value)
    let test=this.profileForm.value
    console.log(this.profileForm.value)

     this.registerService.saveUser(test).subscribe(response=>
       {
         alert("Successfully Regiter Please Login"); 
       alert("successfully added-your id is------"+response.userId);

    console.log(response);
    // window.location.reload();
    this.router.navigateByUrl('/login')
  }, error => {

    if(error.status==500)
    {
      alert("email is already in use");
    }
  }
  );
 
  }
 
  selectedFile: any;
  url:any;
  getFileData(event: any) {
    let f=new FileReader();
    this.selectedFile=event.target.files[0]?? null;
    f.readAsDataURL(event.target.files[0]);
    f.onload = (_event) => {
      // this.msg = "";
      this.url = f.result;
    }
  }
  get email() {
    return this.profileForm.get('email');
  }
  get password() {
    return this.profileForm.get('password');
  }
  get firstName() {
    return this.profileForm.get('firstName');
  }
  get lastName() {
    return this.profileForm.get('lastName');
  }
  get contactNo() {
    return this.profileForm.get('contactNo');
  }
  get age() {
    return this.profileForm.get('age');
  }
}
