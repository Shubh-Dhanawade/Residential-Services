import { Component } from '@angular/core';
import { NavComponent } from "../../home/nav/nav.component";
import { Router } from '@angular/router';
import { UserServicesService } from '../../Services/user-services.service';

@Component({
  selector: 'app-homepage',
  imports: [NavComponent],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {

   constructor(public userServices:UserServicesService , public router: Router){
  
    }

     userTrue:boolean = false;
     workerTrue:boolean = false;
     homeTrue:boolean = true;

    

    //  if (condition) {
      
    //  }

}
