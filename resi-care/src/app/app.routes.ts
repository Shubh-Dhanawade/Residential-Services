import { Routes } from '@angular/router';
import { HomepageComponent } from './client/homepage/homepage.component';
import { LoginComponent } from './pages/login/login.component';
import { BookingComponent } from './client/book/booking/booking.component';

export const routes: Routes = [


    {
      path: "" , component: LoginComponent
    },
    {
      path: "home" , component: HomepageComponent
    },
    {
      path: "userbooking", component : BookingComponent
    }




];
