import { Routes } from '@angular/router';
import { HomepageComponent } from './client/homepage/homepage.component';
import { LoginComponent } from './pages/login/login.component';
import { BookingComponent } from './client/book/booking/booking.component';
import { DashboardComponent } from './user/dashboard/dashboard.component';
import { BookServiceComponent } from './user/book-service/book-service.component';

export const routes: Routes = [


    {
      path: "" , component: LoginComponent
    },
    {
      path: "home" , component: HomepageComponent
    },
    {
      path: "userbooking", component : BookingComponent
    }, 
    {
      path: "user/dashboard", component : DashboardComponent
    }, 
    {
      path: "user/workerList", component : BookServiceComponent
    }




];
