import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  imports: [],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {
  constructor (public router:Router){

  }

  public isUserLog:boolean = false
  public isWorkerLog:boolean = false

  userLog(){
    console.log("adsasdas");
 
    // this.router.navigateByUrl('login')
    this.isUserLog = true
    
  }

  workerLog(){
    this.isWorkerLog= true

  }

}
