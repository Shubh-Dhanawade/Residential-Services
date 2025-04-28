import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserServicesService } from '../../Services/user-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


  constructor(public userServices:UserServicesService , public router: Router){

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
    console.log(ref);

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
