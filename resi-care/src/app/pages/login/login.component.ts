import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, NgModule } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { UserServicesService } from '../../Services/user-services.service';
import { Router } from '@angular/router';
import { HomepageComponent } from '../../home/homepage/homepage.component';
import { NavComponent } from '../../home/nav/nav.component';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


  constructor(public userServices:UserServicesService , public router: Router){

  }

 

  workerProfession:string=''
   isUserLog:boolean = false;
   isWorkerLog:boolean = false;

   ngOnInit(){
    this.checkUser();
   }

  checkUser(){

    if(this.router.url == "/userlogin"){
      this.isUserLog = true;
      console.log("User"+this.isUserLog);

    } else if(this.router.url == "/workerlogin"){
      this.isWorkerLog = true;
    }


  }



  login(ref:any){



    this.userServices.login(ref.value).subscribe({
      next: (res:any)=>{
        console.log(res);
        if(res.success){
          this.router.navigateByUrl('/home')

          // ref.


        }else{
          alert("Invalid Email or Password")
        }

      }
    })

  }


  submit(ref:any){
    console.log(ref.value);
    console.log(this.workerProfession);


    this.userServices.addUser(ref.value).subscribe({
      next: (res)=>{
        console.log(res);

      }
    });



  }




  status:any = "";









  signUp(){
    this.status = "active";



  }

  signIn(){
    this.status = "";


  }

}
