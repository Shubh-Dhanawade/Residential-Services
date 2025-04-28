import { NgFor } from '@angular/common';
import { Component } from '@angular/core';


@Component({
  selector: 'app-booking',
  imports: [NgFor],
  templateUrl: './booking.component.html',
  styleUrl: './booking.component.css'
})
export class BookingComponent {
  services = [
    {
      name: 'Worker_name',
      description: 'Plumber',
      icon: 'assets/icons/profile.png'
    },
    {
      name: 'Worker_name',
      description: 'Plumber',
      icon: 'assets/icons/profile.png'

    },{
      name: 'Worker_name',
      description: 'Plumber',
      icon: 'assets/icons/profile.png'

    },

  ];

  bookService(service: any) {
    alert(`You booked: ${service.name}`);
    // You can later route to booking page or open modal
  }


}
