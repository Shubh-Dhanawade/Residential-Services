import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { UserServicesService } from '../../Services/user-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  imports: [NgFor ],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})



export class HomepageComponent {
  constructor(public userServices:UserServicesService , public router: Router){

  }

  services = [
    {
      name: 'Plumber',
      description: 'Fix leaks, install pipes, and more.',
      icon: 'icons/plumber.png'
    },
    {
      name: 'Electrician',
      description: 'Electrical fittings, fan installation, etc.',
      icon: 'icons/electrician.png'
    },
    {
      name: 'Cleaner',
      description: 'Home, kitchen, and bathroom cleaning.',
      icon: 'icons/cleaning.png'
    }
  ];

  bookService(service: any) {
    // alert(`You booked: ${service.name}`);
    this.router.navigateByUrl("userbooking")

    // You can later route to booking page or open modal
  }




}
