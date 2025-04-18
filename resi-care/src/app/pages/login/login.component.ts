import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserServicesService } from '../../Services/user-services.service';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


  constructor(public userServices:UserServicesService){

  }

  login(ref:any){
console.log(ref);

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
