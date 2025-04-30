import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { BookingComponent } from './client/book/booking/booking.component';
import { DashboardComponent } from './user/dashboard/dashboard.component';
import { BookServiceComponent } from './user/book-service/book-service.component';
import { HomepageComponent } from './home/homepage/homepage.component';

export const routes: Routes = [


    {
      path: "" , component: HomepageComponent
    },
    {
      path: "userlogin" , component: LoginComponent
    },
    {
      path: "workerlogin" , component: LoginComponent
    },
    {
      path: "userbooking", component : BookingComponent
    }, 
    {
      path: "user/dashboard", component : DashboardComponent
    }, 
    {
      path: "user/workerList", component : BookServiceComponent
    },
   
   

];
