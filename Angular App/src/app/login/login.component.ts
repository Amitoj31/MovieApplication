import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialog,MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { RegisterComponent } from '../register/register.component';
import { LoginService } from '../services/login.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor( private loginService:LoginService, private router: Router ,public dialog: MatDialog) { }
  
  ngOnInit(): void {
  }
  emails="";
  emailPattern=/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/
  openDialog(): void {
    // this.matdialogconfig.backdropClass=('back');
    this.dialog.open(RegisterComponent, {
      panelClass : 'custom-dialog-container'
    });
  }
  loginForm = new FormGroup({
    email : new FormControl('',[Validators.required,Validators.pattern(this.emailPattern)]),
    password : new FormControl('',[Validators.required,Validators.minLength(3)])
    // file : new FormControl()
  })
  get email() {
    return this.loginForm.get('email');
  }
  get password() {
    return this.loginForm.get('password');
  }
  token:string;
  selectedFile: any;
  login() {
  
    let data=this.loginForm.value;
    
  this.loginService.login(data).subscribe(response=> {
   
   if(response.error=="Not Found") {
      alert("Invalid Credentials try again")
    }
    else {
     
     this.loginService.validateLogin(response.id,response.token)
   
    
     this.router.navigateByUrl('movie')
     alert("Login Successful")
//  if(response.id!=null)
//      {
//        this.lc();
//      }
  
    }
    
  }, error => {
  alert("mail/password is wrong");
  }
  )
 
  

  }
  
  //Added by subhiksha
  // logincheck(email:string)
  // {
  //   console.log("logincheck"+email)
  //   this.loginService.logincheck(email)
  // }
  // lc()
  // {
    
  //   console.log("first"+this.email.value);
  //   this.logincheck(this.email.value);
   
  // }
  showPassword: boolean = false;
  public togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }
}
